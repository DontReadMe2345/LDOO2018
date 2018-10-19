<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Practica6</title>
    <center>
        <style> 
        body {
            
            background-color: white;
            color: black;
            position:relative;
            width:800px;
            height:540px;
            font-size: 30px;  
            font-family: "Console";
            text-align: center;
            
        }
        </style>
    
    </head>
    <body>
        <center><form action="Controlador.java" id="form" method="POST" > 
            <fieldset>
                <legend>Login</legend>
                Correo:<br>
                <input size="50" type="text" name="correo">
                <br>
                Contraseña:<br>
                <input size="50" type="password" name="contra">
                <br>
                <br>
                <input type="submit" value="Entrar" > 
            </fieldset>
        </form>
        </center>
    </body>
</html>