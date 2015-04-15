<%-- 
    Document   : loginfinal
    Created on : 29/01/2015, 12:54:42 AM
    Author     : krito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <title>Iniciar sesión</title>
    </head>
    <body>
        <h1>Bienvenidos</h1>
        <form name="formlogin" action="../i" method="POST">
            <label for="txtCedula">Cedula</label>
            <input type="text" name="txtCedula" value="" size="20" id="txtCedula"/><br>
            <label for="txtClave">Contraseña</label>
            <input type="password" name="txtClave" value="" size="20" id="txtClave" /><br>
            <br>
            <input type="hidden" name="ingresarC" id="ingresarC"/>
            <label for="btnIngresarC"></label>
            <input type="submit" value="Ingresar" name="btnIngresarC" id="btnIngresarC" />
        </form><a href="../registrarpersona.jsp">Registrate!</a>
        <div class="style3">
            <%
                if (request.getParameter("msg") != null) {
                    out.print(request.getParameter("msg"));

                }
            %>
        </div>
    </body>
</html>
