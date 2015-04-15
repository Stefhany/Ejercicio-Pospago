<%-- 
    Document   : registroPersona
    Created on : 3/01/2015, 10:09:06 PM
    Author     : krito
--%>

<%@page import="dtos.PersonaDTO"%>
<%@page import="daos.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <title>Clarín | Registro de línea</title>
    </head>
    <body onload="focusIn();">
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
        <h1 align="center">Registrar línea</h1>
        <div class="wrapper">
            <form name="regristrar" action="../cl" method="post">
                <label for="txtNumero">Número de línea:</label>
                <input type="text" id="txtNumero" name="txtNumero">                   
                <br>
                <label for="txtCedula">Cédula del cliente:</label>
                <input type="text" id="txtCedula" name="txtCedula" required size="10" onchange="validarCedula(this);"/>
                <div id="empResult" style="background-color: white; font-size: 12px; color: red;">
                </div>
                <div id="empResult2" style="background-color: white; font-size: 12px; color: green;">
                </div>
                <br>
                <label for="txtEstado">Estado:</label>
                <select name="txtEstado" >
                    <option>Activa</option>                
                    <option>Suspendida</option>    
                </select><br><br><br>

                <input type="hidden" id="linea" name="linea">
                <a href="perfil.jsp">Inicio</a><input type="submit" id="btnLinea" name="btnLinea" value="Registrar línea">
                <br>
                

                <%
                    if (request.getParameter("msg") != null) {
                        out.print(request.getParameter("msg"));
                    }
                %>
            </form>
        </div>
    </body>
</html>
