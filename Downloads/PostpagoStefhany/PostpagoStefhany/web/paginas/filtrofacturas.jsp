<%-- 
    Document   : filtrofacturas
    Created on : 23-feb-2015, 9:20:47
    Author     : Mona
--%>

<%@page import="dtos.FacturaDTO"%>
<%@page import="dtos.LineaDTO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <title>Clarín | Consultar</title>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <%
            FacturaDTO fdto = new FacturaDTO();
            PersonaDTO pdto = new PersonaDTO();
            LineaDTO lindto = new LineaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("login.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
                
        %>
    </head>
    <body>
        <form name="filtro" action="../cf" method="post">
           <label>Cedula:</label>
           <input type="text" name="txtCedula" value="" size="20"/><br>
           <label>Fecha emisión:</label>
           <input type="date" name="txtFecha" value="" size="20"/><br>
           <input type="submit" value="Consultar" name="enviar" onclick=""/>
        </form>
        <%
            }
        %>
        
        <a href="perfil.jsp">Inicio</a>
    </body>
</html>
