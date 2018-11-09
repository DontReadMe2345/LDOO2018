<%-- 
    Document   : Login
    Created on : 9/11/2018, 09:20:53 AM
    Author     : zenit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="diseñochido.css">
        
        <style> 
			body {
		    background-image: url("t2.jpg");
			}
        </style>
        
        <title>Login</title>
    </head>
    <body>
        
  <div class="container"> 
  <form id="contact" action="Controlador" method="POST">
      
    
      <h3> Ingresa tus datos para que puedas acceder a tu cuenta </h3>
    
    <fieldset>
      <input name="mail"  placeholder="Correo Electronico" type="email" tabindex="2" required>
    </fieldset>
    <fieldset>
        <input  name="contra" placeholder="Contraseña" type="password" tabindex="2" required>
    </fieldset>
    <fieldset>
      <button name="Enviar" type="submit" id="contact-submit" data-submit="...Enviando"> ¡Iniciar Sesion!</button>
    </fieldset>
  
  </form>
      </div>

        
    </body>
</html>