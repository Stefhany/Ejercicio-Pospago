<%-- 
    Document   : listarequipos
    Created on : 11-dic-2014, 9:48:48
    Author     : Sena
--%>

<%@page import="daos.EquipoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="dtos.EquipoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <title>Clarín | Consultar equipos</title>
        <script>
            function confirmar() {
                if (confirm('¿Esta plenamente seguro de cambiar el estado del equipo?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

        </script>
    </head>
    <body>
        <%
            EquipoDTO edto = new EquipoDTO();
            PersonaDTO pdto = new PersonaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");

        %>
        <h1>Equipos</h1>
        <h3>Bienvenido <% out.print(pdto.getPerNombre()); %></h3>
        <%
            EquipoDAO edao = new EquipoDAO();
            ArrayList<EquipoDTO> equipos = new ArrayList();
            equipos = (ArrayList<EquipoDTO>) edao.listarEquipos();
        %>
        <div class="confirmarOK">
            <%
                if (request.getParameter("sal") != null) {
                    out.print(request.getParameter("sal"));
                }
            %>
        </div>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Serial</th>
                    <th>Número línea</th>
                    <th>Marca</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                        <%
                            if (pdto.getPerId() == 1007) {
                        %>   

                    <% }%> 
                    <th>Cambiar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (EquipoDTO equipo : equipos) {
                %>

                <tr>
                    <td><%=equipo.getEquSerial()%></td>
                    <td><%=equipo.getLiNumeroLinea()%></td>
                    <td><%=equipo.getEquMarca()%></td>
                    <td><%=equipo.getEquDescripcion()%></td>
                    <td><%=equipo.getEquEstado()%></td>
                    <%
                        if (pdto.getPerId() == 1012) {
                    %>   
                    <td><a href="../Controlador?idEquipo=<%=edto.getEquSerial()%>" onclick="return confirmar();"><img src="../imagenes/estadoequipo.png" alt="Cambiar estado" title="Cambiar estado"/>
                        </a></td>
                        <% }%> 
                     
                        <%
                            }%>
                </tr>
            </tbody>
        </table>
        <%
            }   // Cierra el else que valida la sesión
        %>
        <h3><a href="perfil.jsp">Inicio</a></h3>
        <h3><a href="listarlinea.jsp">Listar línea</a></h3>
    </tr>
</body>
</html>
