<%-- 
    Document   : perfil
    Created on : 28/01/2015, 06:29:13 PM
    Author     : krito
--%>

<%@page import="dtos.LineaDTO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <title>Clarín  | Mi perfil </title>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <%
            PersonaDTO pdto = new PersonaDTO();
            LineaDTO lindto = new LineaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
            }
        %>
    </head>
    <body>
        <h1 align="center">Bienvenido  al SI Clarín!</h1>
        <div class="wrapper">
            <nav class="vertical">
                <ul>
                    <li>
                        <a href="#">Línea</a>
                        <div>
                            <ul>
                                <li><a href="registrolinea.jsp">Registrar</a></li>                            
                                <li><a href="modificarlinea.jsp">Actualizar</a></li>
                                <li><a href="listarlinea.jsp">Consultar líneas</a></li>                                
                                <li><a href="reporte.jsp">Auditoria</a></li>    
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#">Equipo</a>
                        <div>
                            <ul>
                                <li><a href="registrarequipo.jsp">Registrar</a></li>
                                <li><a href="listarequipos.jsp">Consultar equipos</a></li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="#">Usuarios</a>
                        <div>
                            <ul>
                                <li><a href="../registrarpersona.jsp">Registrar</a></li>
                                <li><a href="modificarusuario.jsp">Actualizar</a></li>
                                <li><a href="listarpersonas.jsp">Consultar usuarios</a></li>
                                <li><a href="listado.jsp">Consultar facturas</a></li>
                                <li><a href="filtrofacturas.jsp">Buscar facturas</a></li>
                            </ul>
                        </div>
                    </li><br>
                <li><a href="cerrar.jsp">Cerrar sesión</a></li>  
            </nav>
        </div>
        <div class="style3">
            <%
                if (request.getParameter("msg") != null) {
                    out.print(request.getParameter("msg"));

                }
            %>
        </div>
    </body>
</html>
