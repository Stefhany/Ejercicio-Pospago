<%-- 
    Document   : registrarpersona
    Created on : 8/12/2014, 07:39:32 PM
    Author     : krito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <SCRIPT language="JavaScript" src="js/ValidaUsuario.js"></SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/mystyle.css" type="css/txt">
        <title>Clarín | Registro</title>
    </head>
    <body onload="focusIn();">
        <h3>Registrate!</h3>

        <form name="registropersona" action="Controlador" method="POST">
                           
            <label for="txtNombre">Nombre</label>
            <input type="text" name="txtNombre" id="txtNombre" value="" size="40" required="true"/>
            <br>
            <label for="txtApellido">Apellido</label>
            <input type="text" name="txtApellido" id="txtApellido" value="" size="40" required="true"/>
            <br>
            <label for="txtTelefono">Telefono Fijo</label>
            <input type="text" name="txtTelefono" id="txtTelefono" value="" size="40" required="true"/>
            <br>
            <label for="txtFechaNacimiento">Fecha Nacimiento</label>
            <input type="date" name="txtFechaNacimiento" id="txtFechaNacimiento" value="" size="40" required="true"/>
            <br>
            <label for="txtCedula">Cedula</label>
            <input type="text" name="txtCedula" id="txtCedula" value="" size="40" required="true"/>
            <br>
            <label for="txtUsuario">Usuario</label>
            <input type="text" name="txtUsuario" id="txtUsuario" value="" size="40" required="true"/>
            <br>
            <label for="txtClave">Clave</label>
            <input type="password" name="txtClave" id="txtClave" value="" size="40" required="true"/>
            <br>
            
            <input type="hidden" name="registrarPersona" id="registrarPersona" value="" />
            <input type="submit" value="Registrar" name="btnRegistrarPersona" />
            <br>
        </form>
    </body>
    <div class="style3">
            <%
                if (request.getParameter("msg") != null) {
                    out.print(request.getParameter("msg"));

                }
            %>
        </div>
</html>
