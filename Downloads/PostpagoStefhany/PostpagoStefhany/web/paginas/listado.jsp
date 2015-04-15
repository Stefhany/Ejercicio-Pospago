<%-- 
    Document   : listado
    Created on : 8/12/2014, 09:58:21 PM
    Author     : krito
--%>

<%@page import="dtos.LineaDTO"%>
<%@page import="dtos.FacturaDTO"%>
<%@page import="daos.FacturaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daos.PersonaDAO"%>
<%@page import="dtos.PersonaDTO"%>
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
        <title>Clarín | Consultar facturas</title>
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
            function asegurar() {
                if (confirm('¿Esta plenamente seguro de cambiar de estado este equipo?')) {
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <%
            FacturaDTO fdto = new FacturaDTO();
            PersonaDTO pdto = new PersonaDTO();
            LineaDTO lindto = new LineaDTO();
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usuarioLogueado") == null) {
                response.sendRedirect("loginfinal.jsp?msg= Usuario No Encontrado!!");
            } else {
                pdto = (PersonaDTO) miSesion.getAttribute("usuarioLogueado");
                
                FacturaDAO fdao = new FacturaDAO();
                fdto = fdao.consultarByFactura(1012);
                
        %>
        <h1>Facturas</h1>

        <%
            
            ArrayList<FacturaDTO> facturas = new ArrayList();
            facturas = (ArrayList<FacturaDTO>) fdao.listarFacturas();
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
                    <th>Número factura</th>
                    <th>Número línea</th>
                    <th>Fecha emisión</th>
                    <th>Valor</th>
                        <%
                            if (pdto.getPerId() == 1111) {
                        %>   
                    <th>Modificar</th>
                        <% }%> 
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (FacturaDTO factura : facturas) {
                %>

                <tr>
                    <td><%=factura.getFacNumero()%></td>
                    <td><%=factura.getLiNumeroLinea()%></td>
                    <td><%=factura.getFacFechaEmision()%></td>
                    <td><%=factura.getFacValor()%></td>
                    <%
                        if (pdto.getPerId() == 1015) {
                    %>   
                    <td><a href="../Controlador?id=<%=fdto.getFacNumero()%>" onclick="return asegurar();"><img src="../imagenes/modificar.png" alt="Eliminar factura" title="Eliminar"/>
                        </a></td>
                        <% }%> 
                    <td><a href="modificar.jsp?id=<%=fdto.getFacNumero()%>"><img src="../imagenes/eliminar.png" alt="Modificar factura" title="Modificar"/>
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
