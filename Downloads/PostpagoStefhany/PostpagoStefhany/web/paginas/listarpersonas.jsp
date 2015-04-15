<%-- 
    Document   : listarpersonas
    Created on : 23-feb-2015, 8:35:41
    Author     : Mona
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="daos.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <%
            PersonaDAO perdao = new PersonaDAO();
            ArrayList<PersonaDTO> personas = new ArrayList();
            personas = perdao.listarPersonas();
        %>
        <title>Clarín | Usuarios registrados</title>
    </head>
    <body>
        <%  
            PersonaDTO pdto = new PersonaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");

        %>
        <script>
            function confirmar() {
                if (confirm('¿Esta seguro de borrar este pedido?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

        <table name="solicitudes" border="1" class="table table-striped" style="width:80%" aling="center">
            <thead>
                <tr>    
                    <th>Cedula</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Telefono</th>
                    <th>Fecha nacimiento</th>
                </tr>                
            </thead>
            <tbody>
                <%
                    for (PersonaDTO ped : personas) {
                %>
                <tr>
                    <td><%=ped.getPerCedula()%></td>
                    <td><%=ped.getPerNombre()%></td>
                    <td><%=ped.getPerApellido()%></td>
                    <td><%=ped.getPerTelefonoFijo()%></td>  
                    <td><%=ped.getPerFechaNacimiento()%></td>

                </tr>
                <%}}
                %>
            </tbody>
        </table>
        <a href="../registrarpersona.jsp">Registrar nuevo usuario</a>
    </body>
</html>
