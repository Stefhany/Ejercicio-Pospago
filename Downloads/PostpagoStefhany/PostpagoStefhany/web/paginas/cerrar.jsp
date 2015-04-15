<%-- 
    Document   : cerrar
    Created on : 8/12/2014, 10:55:52 PM
    Author     : krito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
    </head>
    <body>
        <h1>Salir</h1>
        
        <%         
            HttpSession miSesion = request.getSession(false);
            
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= redireccion desde logout");

            } else {
                miSesion.removeAttribute("usuarioLogueado");
                miSesion.invalidate();
                response.sendRedirect("loginfinal.jsp?msg= Sesion cerrada");
            }
        %>   
    </body>
</html>
