<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>        
        <meta charset="UTF-8">
        <title>Inicio Sesión</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="ServletControlEntrada" method="post">
            Nick:<input name="nick">
            Contraseña:<input name="contrasena" type="password">
            <input type="submit" value="Entrar" >
        </form>
        <a href="registro-nuevo-usuario.jsp">Registro nuevos usuarios</a>
        <br><br><br><br>
        <h1>Comprobar que la contraseña es correcta</h1>
        <h1>Si no es correcta mostrar mensaje de error...</h1>
    </body>
</html>
