<%-- 
    Document   : Perfil
    Created on : 9/11/2018, 09:21:52 AM
    Author     : zenit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Perfil</title>
        
         <link rel="stylesheet" href="diseñochido.css">
        
        <style> 
			body {
		    background-image: url("t2.jpg");
			}
        </style>
        
    </head>
    <body>
         <div class="container">
             
  <form id="contact" action="Controlador" method="POST">
      
    
      <h3> ¡Bienvenido! </h3>
    
    <fieldset>
        ¿Que desea Ordenar?
      <input name="nombre" type="text" tabindex="2">
    </fieldset>
    <fieldset>
        <input  name="varcontrol" type="hidden" tabindex="2" value="2">
    </fieldset>
    <fieldset>
        <button name="Enviar" type="submit" value="Registrar" id="contact-submit" data-submit="...Enviando"> ¡Enviar!</button>
    </fieldset>
  
  </form>
      </div>
        
    </body>
</html>
