<%-- 
    Document   : registrarequipo
    Created on : 29/01/2015, 12:36:52 AM
    Author     : krito
--%>

<%@page import="daos.PersonaDAO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="dtos.LineaDTO"%>
<%@page import="daos.LineaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <title>Clarín | Registrar equipo</title>
        <%
            LineaDAO lin = new LineaDAO();
            LineaDTO lindto = new LineaDTO();
            lindto = lin.consultarById(3453534);
        %>
    </head>
    <body>
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
        <h1>Registrar equipo!</h1>
        <form name="regristrar" action="../Controlador" method="POST">
            <label for="txtSerial">Serial del equipo:</label>
            <input type="text" id="txtSerial" name="txtSerial" required><br>

            <label for="txtLinea">Número de línea:</label>
            <input type="text" id="txtLinea" name="txtLinea" value="<%
            if (lindto != null) {
                    out.println(lindto.getLinumerolinea());
                }
            %>"><br>

            <label for="txtMarca">Marca:</label>
            <input type="text" id="txtMarca" name="txtMarca" required><br>
            
            <label for="txtDescripcion">Descripción:</label>
            <input type="text" id="txtDescripcion" name="txtDescripcion" required><br>
            
            <label for="txtEstado">Estado:</label>
            <select name="txtEstado" >
                <option>Reportado</option>
                <option>No reportado</option>    
            </select><br>
            
            <input type="hidden" id="registrarEquipo" name="registrarEquipo">
            <input type="submit" id="btnRegistrarEquipo" name="btnRegistrarEquipo" value="Registrar equipo">
            
            <%
            if(request.getParameter("msg")!=null){
                out.print(request.getParameter("msg"));
            }
            %>
        </form>
        
        <a href="perfil.jsp">Inicio</a>
    </body>
</html>
