<%-- 
    Document   : galeria
    Created on : 20-nov-2018, 15:38:21
    Author     : DAW
--%>
<%@page import="Clases.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Galeria</title>
    </head>
    <body>       
        <% 
        HttpSession sesion = request.getSession(true);
        Usuario u = (Usuario) sesion.getAttribute("nick");
        if(sesion.getAttribute("nick") == null){
            response.sendRedirect(response.encodeRedirectURL("index.jsp"));
        }else{
            %>
            <a href="CerrarSesion">Cerrar Sesión</a>
            <br><br>
            <h1>Bienvenuts!! <%= " Señor@ " + u.getNombre() %></h1>
            <form action="ModificarDatosUsuario" method="post">
                Nick:<input name="nick" value="<%= u.getNick() %>" readonly>
                <br><br>
                Contraseña vieja:<input name="contrasena" type="password" value="">
                <br><br>
                Contraseña nueva:<input name="contrasena1" type="password" value="" minlength="6">
                <br><br>
                Repite contraseña:<input name="contrasena2" type="password" value="" minlength="6">
                <br><br>
                
                Nombre:<input name="nombre" type="text" value="<%= u.getNombre() %>">
                <br><br>
                Apellidos:<input name="apellidos" type="text" value="<%= u.getApellidos() %>">
                <br><br>
                Teléfono:<input name="telefono" type="text" value="<%= u.getTelefono() %>">
                <br><br>
                Dirección:<input name="direccion" type="text" value="<%= u.getDireccion() %>">
                <br><br>
                <input name="tipo" type="text" value="<%= u.getTipo() %>" style="display:none">
                <br><br>
                <input type="submit" value="Modificar Datos" >
            </form>
            <form action="EliminarUsuario" method="post">
                <input name="nick" value="<%= u.getNombre() %>" style="display:none">
                <input name="contrasena" type="password" value="<%= u.getContrasena() %>" style="display:none">
                <br><br>
                <input type="submit" value="Eliminar mi cuenta" >
            </form>
            <%
        }%>
    </body>
</html>
