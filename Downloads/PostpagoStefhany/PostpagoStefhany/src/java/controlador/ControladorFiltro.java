/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import daos.FacturaDAO;
import dtos.FacturaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mona
 */
public class ControladorFiltro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String filtro = "";
            if (request.getParameter("txtCedula") != null && request.getParameter("txtCedula") != "") {

                filtro += " AND percedula =" + Integer.parseInt(request.getParameter("txtCedula"));
            } else {
                filtro += " WHERE percedula like('%')";
            }

            if (request.getParameter("txtFecha") != null && request.getParameter("txtFecha") != "") {

                filtro += " AND facfechaemision like('%" + request.getParameter("txtFecha") + "%')";
            }

            //llamar al metodo   
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Clarín | Buscar factura</title>");
            out.println("</head>");
            out.println("<body>");

            //out.print("ksdvjsdvjj kjsnva ios"+filtro);
            out.print(" <SCRIPT language=\"JavaScript\" src=\"../js/ValidaUsuario.js\"></SCRIPT>\n"
                    + " <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + " <link rel=\"stylesheet\" href=\"../css/mystyle.css\" type=\"css/txt\" >");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Número factura</th>");
            out.println("<th>Número de línea</th>");
            out.println("<th>Fecha</th>");
            out.println("<th>Valor</th>");
            out.println("<th>Eliminar</th>");
            out.println("</tr>");
            FacturaDAO con = new FacturaDAO();
            LinkedList<FacturaDTO> filtrar = new LinkedList();
            filtrar = (LinkedList<FacturaDTO>) con.consultarFiltro(filtro);
            //out.print(filtrar.size());
            if (filtrar.size() != 0) {
                for (int i = 0; i < filtrar.size(); i++) {
                    out.println("<tr>");
                    out.println("<td>" + filtrar.get(i).getFacNumero() + "</td>");
                    out.println("<td>" + filtrar.get(i).getLiNumeroLinea() + "</td>");
                    out.println("<td>" + filtrar.get(i).getFacFechaEmision() + "</td>");
                    out.println("<td>" + filtrar.get(i).getFacValor() + "</td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<tr>");
                out.println("<td>No se encontraron registros.</td>");
                out.println("<td>No se encontraron registros.</td>");
                out.println("<td>No se encontraron registros.</td>");
                out.println("<td>No se encontraron registros.</td>");
                out.println("</tr>");
            }

            out.println("</table>");
//            out.println("<h2> Consultar !</h2>");
//            out.println("<h3>EL FILTRO PARA LA CONSULTAR ES ;<br /> </h3><H1>" + con.listarSolicitudesDeAsociacion(filtro) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
