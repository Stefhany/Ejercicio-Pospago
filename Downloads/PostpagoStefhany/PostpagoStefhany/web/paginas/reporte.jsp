<%-- 
    Document   : reporte
    Created on : 04-mar-2015, 10:03:44
    Author     : Mona
--%>

<%@page import="daos.PersonaDAO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="dtos.AuditoriaDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="daos.AuditoriaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <%
            AuditoriaDAO sol = new AuditoriaDAO();
            LinkedList<AuditoriaDTO> listaSalida = new LinkedList();
            listaSalida = (LinkedList<AuditoriaDTO>) sol.consultar();
        %>
        <title>Clarín | Auditoria</title>
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
        <table name="solicitudes" border="1" class="table table-striped" style="width:80%" aling="center">
            <thead>
                <tr>    
                    <th>Usuario</th>
                    <th>Número línea</th>
                    <th>Acción</th>
                    <th>Fecha</th>
                </tr>                
            </thead>
            <tbody>
                <%
                    for (AuditoriaDTO ped : listaSalida) {
                %>
                <tr>
                    <td><%=ped.getUsuario()%></td>
                    <td><%=ped.getNumLinea()%></td>
                    <td><%=ped.getAccion()%></td>
                    <td><%=ped.getFecha()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <a href="../perfil.jsp">Inicio</a>
    </body>
</html>
