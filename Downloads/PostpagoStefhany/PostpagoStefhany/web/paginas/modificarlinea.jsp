<%-- 
    Document   : modificarlinea
    Created on : 03-mar-2015, 13:23:39
    Author     : Mona
--%>

<%@page import="daos.LineaDAO"%>
<%@page import="dtos.LineaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <title>Clarín | Modificar línea</title>
        <%
            LineaDTO lin = new LineaDTO();
            LineaDAO linDao = new LineaDAO();
            lin = linDao.consultarById(3453534);
        %>
    </head>
    <body>
        <%
            LineaDTO lindto = new LineaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } //else {
                //pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
                
                //FacturaDAO fdao = new FacturaDAO();
                //fdto = fdao.consultarByFactura(1012);
                
        %>
        <h1 align="center">Modificar línea</h1>
        <div class="wrapper">
            <form name="regristrar" action="../cl" method="post">
                <label for="txtNumero">Número de línea:</label>
                <input type="text" id="txtNumero" name="txtNumero"
                       value="<% if (lin != null) {
                               out.println(lin.getLinumerolinea());
                           }
                       %>">                   
                <br>
                <label for="txtCedula">Cédula del cliente:</label>
                <input type="text" id="txtCedula" name="txtCedula" required size="10" value="<%if (lin != null) {
                        out.println(lin.getP().getPerNombre());
                    }
                       %>"/>
                
                <br>
                <label for="txtEstado">Estado:</label>
                <select name="txtEstado" value="<%if (lin != null) {
                        out.println(lin.getLinestado());
                    }
                        %>">
                    <option>Activa</option>                
                    <option>Suspendida</option>    
                </select><br>

                <input type="hidden" id="modificarLinea" name="modificarLinea">
                <input type="submit" id="btnModificarLinea" name="btnModificarLinea" value="Actualizar línea">
                <a href="perfil.jsp">Inicio</a>

                <%
                    if (request.getParameter("msg") != null) {
                        out.print(request.getParameter("msg"));
                    }
                %>
            </form>
        </div>
            <a href="perfil.jsp">Inicio</a>
    </body>
</html>
