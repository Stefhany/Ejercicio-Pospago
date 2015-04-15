<%-- 
    Document   : index
    Created on : 28/01/2015, 10:39:02 PM
    Author     : krito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <SCRIPT language="JavaScript" src="../js/ValidaUsuario.js"></SCRIPT>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/mystyle.css" type="css/txt" >
        <title>Clarín | Home</title>
    </head>
    <body>
        <h1>Misión</h1>
        <p> Brindar a través de nuestros productos y servicios en el sector de las telecomunicaciones 
            la optima satisfacción a nuestros distribuidores y clientes. 
            Sustentados por una empresa económicamente prospera comprometida con el desarrollo de su 
            personal y de la sociedad donde se ubica.</p>
        
        <h1>Visión</h1>    
        <p>Situarnos como altos líderes en el mercado de telecomunicaciones, a través de nuestro producto, servicio, calidad e innovación. Teniendo como meta la satisfacción de nuestros clientes. Siempre guiados por una actitud ética y honesta. Nuestro personal es calificado y 
            ha sido inculcado con la directriz de prestar servicios de alta calidad.
        </p>
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
