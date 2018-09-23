<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Practica4</title>
        <% String Usuario = request.getParameter("Usuario");
           String Correo = request.getParameter("Correo");
           String Contraseña = request.getParameter("Contraseña");
           %>
           
    </head>
    <body>
        <p> Has iniciado sesion,  <%=Usuario%></p><br>
        <p> Tu corre electronico es: <%=Correo%></p><br>
        <p> Tu contraseña es: <%=Contraseña%></p>
        
    </body>
</html>
