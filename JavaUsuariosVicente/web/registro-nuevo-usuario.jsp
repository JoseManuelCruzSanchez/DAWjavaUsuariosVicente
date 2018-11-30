<%-- 
    Document   : formulario-usuario-nuevo
    Created on : 20-nov-2018, 15:55:18
    Author     : DAW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <form action="RegistroNuevoUsuario" method="post">
            Nick:<input name="nick">
            Contraseña:<input name="contrasena1" type="password" minlength="6">
            Repite contraseña:<input name="contrasena2" type="password" minlength="6">
            Nombre:<input name="nombre" type="text">
            Apellidos:<input name="apellidos" type="text">
            Teléfono:<input name="telefono" type="text">
            Dirección:<input name="direccion" type="text">
            <input type="submit" value="Envialo" >
        </form>
    </body>
</html>
