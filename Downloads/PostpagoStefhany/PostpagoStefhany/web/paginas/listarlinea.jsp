<%-- 
    Document   : listarlinea
    Created on : 11-dic-2014, 10:10:37
    Author     : Sena
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="daos.LineaDAO"%>
<%@page import="dtos.PersonaDTO"%>
<%@page import="dtos.LineaDTO"%>
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
        <title>Clarín | Consultar líneas</title>
        <script>
            function confirmar() {
                if (confirm('¿Esta plenamente seguro de borrar este registro?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <script>
            function validar() {
                if (confirm('¿Esta plenamente seguro de cambiar el estado del equipo?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>

    </head>
    <body>
        <%
            LineaDTO lindto = new LineaDTO();
            PersonaDTO pdto = new PersonaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");

        %>
        <h1>Líneas</h1>
        <h3>Bienvenido <% out.print(pdto.getPerNombre()); %></h3>
        <%
            LineaDAO lindao = new LineaDAO();
            ArrayList<LineaDTO> lineas = new ArrayList();
            lineas = (ArrayList<LineaDTO>) lindao.listarLineas();
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
                    <th>Persona</th>
                    <th>Número línea</th>
                        <%
                            if (pdto.getPerId() == 1007) {
                        %>   

                    <% }%> 
                    <th>Estado línea</th>
                    <th>Eliminar</th>
                    <th>Modificar</th>
                    <th>Cambiar estado</th>

                </tr>
            </thead>
            <tbody>
                <%
                    for (LineaDTO linea : lineas) {
                %>

                <tr>
                    <td><%=linea.getPerid()%></td>
                    <td><%=linea.getLinumerolinea()%></td>
                    <td><%=linea.getLinestado()%></td>


                    <%
                        if (pdto.getPerId() == 1012) {
                    %>   
                    <td><a href="../Controlador?id=<%=lindto.getLinestado()%>" onclick="return confirmar();"><img src="../imagenes/eliminar.png" alt="Eliminar factura" title="Eliminar"/>
                        </a></td>
                        <% }%> 
                    <td><a href="modificar.jsp?id=<%=lindto.getLinestado()%>"><img src="../imagenes/modificar.png" alt="Modificar factura" title="Modificar"/>
                        </a></td>  
                        <td><a href="../cl?idLinea=<%=lindto.getLinumerolinea() %>" onclick="return validar();"><img src="../imagenes/estadoequipo.png" alt="Cambiar estado" title="Cambiar estado" style="text-align: center;"/>
                        </a></td>
                        <%
                            }%>
                </tr>
            </tbody>
        </table>
        <%
            }   // Cierra el else que valida la sesión
        %>
        <h3><a href="perfil.jsp">Inicio</a></h3>

    </body>
</html>
