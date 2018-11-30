package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Teru
 */
public class Usuario {
    private String nick;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String direccion;
    private String tipo;

    public Usuario(String nick, String contrasena, String nombre, 
            String apellidos, String telefono, String direccion, String tipo) {
        this.nick = nick;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNick(){
        return this.nick;
    }
    
    
    public String getContrasena(){
        return this.contrasena;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
        
    
    public String getDatosUsuario(){
        return "nombre => "+this.nick+" Contraseña => "+this.contrasena;
    }
    
}
