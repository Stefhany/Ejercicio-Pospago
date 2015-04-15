/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import daos.EquipoDAO;
import daos.FacturaDAO;
import daos.LineaDAO;
import daos.PersonaDAO;
import dtos.EquipoDTO;
import dtos.FacturaDTO;
import dtos.LineaDTO;
import dtos.PersonaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author krito
 */
public class Controlador extends HttpServlet {

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
        String salida;
        PersonaDTO pdto = new PersonaDTO();
        PersonaDAO pdao = new PersonaDAO();
        FacturaDAO fdao = new FacturaDAO();
        FacturaDTO fdto = new FacturaDTO();
        try {
           if (request.getParameter("btnRegistrarPersona") != null && request.getParameter("registrarPersona") != null) {
                out.print("ok");
                pdto.setPerNombre(request.getParameter("txtNombre").trim());
                pdto.setPerApellido(request.getParameter("txtApellido").trim());
                pdto.setPerTelefonoFijo(request.getParameter("txtTelefono").trim());
                pdto.setPerFechaNacimiento(request.getParameter("txtFechaNacimiento").trim());
                pdto.setPerCedula(request.getParameter("txtCedula").trim());
                pdto.setUser(request.getParameter("txtUsuario").trim());
                pdto.setClave(request.getParameter("txtClave").trim());
                salida = pdao.insertarPersona(pdto);
                response.sendRedirect("paginas/index.jsp?msg= "+salida);
                
            } else if (request.getParameter("btnIngresar") != null && request.getParameter("ingresar") != null){
                //pdto = pdao.validarUsuario(Integer.parseInt(request.getParameter("txtUsuario")), request.getParameter("txtClave"));
                if (pdto.getPerId() != 0) {
                    HttpSession miSesion = request.getSession(true);
                    miSesion.setAttribute("usuarioLogueado", pdto);
                    response.sendRedirect("paginas/perfil.jsp");
                }else{
                    response.sendRedirect("paginas/loginfinal.jsp?msg= Usuario No Existe!! ");
                }
            }else if (request.getParameter("id") != null) {
                //invoco el metodo eliminar
                String sal = "";  //resultadoEliminar
                sal = fdao.eliminarFactura(Integer.parseInt(request.getParameter("id")));
                // espero la respusta y redirecciono
                response.sendRedirect("paginas/listado.jsp?msg" + sal);

            } else if (request.getParameter("btnModificarFactura") != null && request.getParameter("modFactura") != null) {
                fdto.setLiNumeroLinea(request.getParameter("txtLínea").trim());
                fdto.setFacFechaEmision(request.getParameter("txtFecha").trim());
                fdto.setFacValor(Float.parseFloat(request.getParameter("txtValor").trim()));
                fdao.modificarFactura(fdto);
                response.sendRedirect("../paginas/listado.jsp?msg");
                //1. recojo los datos del formulario
                //2. Creo el Dao
                //3.llamo al método modificar
                //4. Esperar la respuesta
                //5. redireccionar
                
            } else if (request.getParameter("btnRegistrarLinea") != null && request.getParameter("registrarLinea") != null){
                LineaDTO lindto = new LineaDTO();
                LineaDAO lindao = new LineaDAO();
                lindto.setLinumerolinea(request.getParameter("txtNumero").trim());
                lindto.setPerid(Integer.parseInt(request.getParameter("txtCedula").trim()));
                lindto.setLinestado(request.getParameter("txtEstado").trim());
                salida = lindao.insertarLinea(lindto);
                //salida = "miree";
                response.sendRedirect("paginas/registrarequipo.jsp?msg= " +salida);
            }else if (request.getParameter("btnRegistrarEquipo")!= null && request.getParameter("registrarEquipo") != null){
                EquipoDTO edto = new EquipoDTO();
                EquipoDAO edao = new EquipoDAO();
                edto.setEquSerial(Integer.parseInt(request.getParameter("txtSerial").trim()));
                edto.setLiNumeroLinea(request.getParameter("txtLinea").trim());
                edto.setEquMarca(request.getParameter("txtMarca").trim());
                edto.setEquDescripcion(request.getParameter("txtDescripcion").trim());
                edto.setEquEstado(request.getParameter("txtEstado"));
                salida = edao.insertarEquipo(edto);
                response.sendRedirect("paginas/index.jsp?msg= "+salida);
            } else if (request.getParameter("idEquipo") != null) {
                EquipoDAO equi = new EquipoDAO();
                String salidaEstado = ""; 
                salidaEstado = equi.cambiarEstado(Integer.parseInt("idEquipo"));
                response.sendRedirect("paginas/listado.jsp?msg= " + salidaEstado);
            }else if (request.getParameter("btnModPersona") != null && request.getParameter("modPersona") != null) {
                PersonaDTO p = new PersonaDTO();
                PersonaDAO per = new PersonaDAO();
                p.setPerId(Integer.parseInt(request.getParameter("txtId").trim()));
                p.setPerTelefonoFijo(request.getParameter("txtTelefono").trim());
                p.setClave(request.getParameter("txtClave").trim());
                String sal = per.modificarPersona(pdto);
                response.sendRedirect("paginas/perfil.jsp?msg= "+sal);
            }
            else {
                out.println("esta intentando acceder de forma fraudulenta");
            }
        }finally{
            salida = "Super";
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
