/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import daos.LineaDAO;
import daos.PersonaDAO;
import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mona
 */
public class ControladorLinea extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("btnRegistrarLinea") != null && request.getParameter("registrarLinea") != null) {
                LineaDTO lindto = null;
                PersonaDTO pdto = new PersonaDTO();
                PersonaDAO pdao = new PersonaDAO();
                lindto = pdao.validarUsuarioParaLinea(Integer.parseInt(request.getParameter("txtCedula")));
                if (pdto.getPerId() != 0) {
                    lindto = new LineaDTO();
                    LineaDAO lindao = new LineaDAO();
                    lindto.setLinumerolinea(request.getParameter("txtNumero").trim());
                    lindto.setPerid(Integer.parseInt(request.getParameter("txtCedula").trim()));
                    lindto.setLinestado(request.getParameter("txtEstado").trim());
                    String salida = lindao.insertarLinea(lindto);
                    response.sendRedirect("paginas/registrolinea.jsp?msg " + salida);
                } else {
                    response.sendRedirect("paginas/registrolinea.jsp?msg=Usuario no registrado!!");
                }
            } else if (request.getParameter("btnModificarLinea") != null && request.getParameter("modificarLinea") != null) {
                LineaDTO lin = new LineaDTO();
                LineaDAO l = new LineaDAO();
                lin.setLinumerolinea(request.getParameter("txtNumero"));
                lin.setLinestado(request.getParameter("txtEstado"));
                String salida = l.modificarLinea(lin);
                response.sendRedirect("paginas/perfil.jsp?msg= " + salida);
            } else if (request.getParameter("idLinea") != null) {
                LineaDAO l = new LineaDAO();
                String salidaEstado = "";
                //salidaEstado = l.cambiarEstado(Integer.parseInt("idLinea"));
                response.sendRedirect("paginas/perfil.jsp?msg= " + salidaEstado);
            } else if (request.getParameter("btnLinea") != null && request.getParameter("linea") != null) {
                LineaDTO lindto = new LineaDTO();
                LineaDAO lindao = new LineaDAO();
                String sal = lindao.registrarLinea(request.getParameter("txtNumero").trim(),
                        Integer.parseInt(request.getParameter("txtCedula").trim()),
                        request.getParameter("txtEstado").trim());
                //salida = "miree";
                response.sendRedirect("paginas/registrarequipo.jsp?msg= " + sal);
            }
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
