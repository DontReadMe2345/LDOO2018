<%-- 
    Document   : Registro
    Created on : 9/11/2018, 09:20:32 AM
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
        
        <title>Registro</title>
    </head>
    <body>
        
  <div class="container"> 
  <form id="contact" action="Controlador" method="POST">
      
    
      <h3> Registrate colocando tus datos a continuacion</h3>
    
    <fieldset>
      <input name="nombre" placeholder="Nombre" type="text" tabindex="1" required autofocus>
    </fieldset>
    <fieldset>
      <input name="correo" placeholder="Correo Electronico" type="email" tabindex="2" required>
    </fieldset>
    <fieldset>
        <input  name="pass" placeholder="Contraseña" type="password" tabindex="2" required>
    </fieldset>
    <fieldset>
      <button name="Enviar" type="submit" id="contact-submit" data-submit="...Enviando"> ¡Registrar!</button>
    </fieldset>
  
  </form>
      </div>

        
    </body>
</html>
