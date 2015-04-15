<%-- 
    Document   : modificar
    Created on : 8/12/2014, 11:05:17 PM
    Author     : krito
--%>

<%@page import="daos.FacturaDAO"%>
<%@page import="daos.PersonaDAO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="dtos.FacturaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <title>Clarín | Modificar Usuario</title>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <%
            PersonaDTO pdto = new PersonaDTO();
            PersonaDAO pdao = new PersonaDAO();
            FacturaDTO fdto = new FacturaDTO();
            FacturaDAO fdao = new FacturaDAO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
                if(request.getParameter("id") != null){
                    fdto = (FacturaDTO) fdao.consultarByIdFactura(Integer.parseInt(request.getParameter("id")));
                }
            }
        %>
    </head>
    <body>
        
        <form name="modFactura" action="../Controlador" method="POST">
            <label for="txtNumero">Número factura</label>
            <input type="text" name="txtNumero" id="txtNumero" value="<%if(fdto !=null){out.print(fdto.getFacNumero());}%>" size="40" />
            <br>
            <label for="txtLínea">Línea</label>
            <input type="text" name="txtLínea" id="txtLínea" value="<%if(fdto !=null){out.print(fdto.getLiNumeroLinea());}%>" size="40"  />
            <br>
            <label for="txtFecha">Fecha emisión</label>
            <input type="text" name="txtFecha" id="txtFecha" value="<%if(fdto !=null){out.print(fdto.getFacFechaEmision());}%>" size="40" />
            <br>
            <label for="txtValor">Valor</label>
            <input type="text" name="txtValor" id="txtValor" value="<%if(fdto !=null){out.print(fdto.getFacValor());}%>" size="40" />
            <br>
             
            <input type="hidden" name="modFactura" id="modFactura" value="" />
            <input type="submit" value="Modificar" name="btnModificarFactura" id="btnModificarFactura" />
            <br>
        </form>

        <%
            if (request.getParameter("msg") != null) {

        %>
        <div class="confirmarOK"><%=request.getParameter("msg")%></div>        

        <%
            }
            // si es null el objeto, es decir, no se ha creado aun, no mostramos nada
        %>
        <a href="perfil.jsp">Inicio</a>
        
    </body>
</html>
