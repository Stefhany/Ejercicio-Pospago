<%-- 
    Document   : modificarusuario
    Created on : 03-mar-2015, 14:39:52
    Author     : Mona
--%>

<%@page import="dtos.FacturaDTO"%>
<%@page import="daos.PersonaDAO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <title>Clarín | Modificar Usuario</title>
        <%
            PersonaDTO pdto = new PersonaDTO();
            PersonaDAO pdao = new PersonaDAO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
                //if(request.getParameter("id") != null){
                //  fdto = (FacturaDTO) fdao.consultarByIdFactura(Integer.parseInt(request.getParameter("id")));
                //}
            }
        %>
    </head>
    <body>
        <form name="registropersona" action="../Controlador" method="POST">
            <input type="hidden" name="txtId" id="txtId" value="<%if (pdto != null) {
                    out.print(pdto.getPerId());
                }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtCedula">Cedula</label>
            <input type="text" name="txtCedula" id="txtCedula" value="<%if (pdto != null) {
                    out.print(pdto.getPerCedula());
                }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtNombre">Nombre</label>
            <input type="text" name="txtNombre" id="txtNombre" value="<%if (pdto != null) {
                    out.print(pdto.getPerNombre());
                }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtApellido">Apellido</label>
            <input type="text" name="txtApellido" id="txtApellido" value="<%if (pdto != null) {
                    out.print(pdto.getPerApellido());
                }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtTelefono">Telefono Fijo</label>
            <input type="text" name="txtTelefono" id="txtTelefono" value="<%if (pdto != null) {
                    out.print(pdto.getPerTelefonoFijo());
                }%>" size="40" required="true"/>
            <br>
            <label for="txtFechaNacimiento">Fecha Nacimiento</label>
            <input type="text" name="txtFechaNacimiento" id="txtFechaNacimiento" value="<%if (pdto != null) {
                    out.print(pdto.getPerFechaNacimiento());
            }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtUsuario">Usuario</label>
            <input type="text" name="txtUsuario" id="txtUsuario" value="<%if (pdto != null) {
                    out.print(pdto.getPerNombre());
                }%>" size="40" required="true" readonly="true"/>
            <br>
            <label for="txtClave">Clave</label>
            <input type="password" name="txtClave" id="txtClave" value="<%if (pdto != null) {
                    out.print(pdto.getPerNombre());
                }%>" size="40" required="true"/>
            <br>

            <input type="hidden" name="modPersona" id="modPersona"/>
            <input type="submit" value="Actualizar" name="btnModPersona" id="btnModPersona"/>
            <br>
        </form>
        <div class="style3">
            <%
                if (request.getParameter("msg") != null) {
                    out.print(request.getParameter("msg"));

                }
            %>
        </div>
        <a href="perfil.jsp">Inicio</a>
    </body>
</html>
