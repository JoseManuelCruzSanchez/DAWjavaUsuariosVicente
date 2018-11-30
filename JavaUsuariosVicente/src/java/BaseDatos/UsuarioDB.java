/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import Clases.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teru
 */
public class UsuarioDB {
    
    private String tablaBD = "usuarios";
    private BaseDatos db;
    
    
    /**
     * Constructor de la clase UsuarioBD, que crea una instancia de la base de datos
     * para poder trabajar sobre ella.
     */
    public UsuarioDB () {
        db = new BaseDatos();
    }
    
    
    
    public Usuario getUsuario(String nombre){

        db.conectar();
        
        //Se ejecuta la consulta
        ResultSet resultUsuario = db.ejecutarSelect("SELECT * FROM " + tablaBD + " WHERE nick='" + nombre + "'");
        Usuario usuario = null;
        try {
            //Si hay resultados se obtienen los datos del usuario
            if (resultUsuario.next()) {
                //UsuarioBD nuevodao = new UsuarioBD();
                usuario = new Usuario(resultUsuario.getString("nick"), resultUsuario.getString("contrasena"), resultUsuario.getString("nombre"), resultUsuario.getString("apellidos"), resultUsuario.getString("telefono"), resultUsuario.getString("direccion"), resultUsuario.getString("tipo"));
                //añadir las propiedades del usuario
                //usuario.setNombre(resultUsuario.getString("Nombre"));
                //usuario.setContrasena(resultUsuario.getString("Contrasena"));               
                db.desconectar();
                return usuario;                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        db.desconectar();
        
        return usuario;
    }
    
    public void registroNuevoUsuario(Usuario usuario){
        db.conectar();
        String nombre = usuario.getNick();
        String contrasena = usuario.getContrasena();
        String tipo = "cliente";
        //Se ejecuta la consulta
        //ResultSet resultUsuario = db.ejecutarSelect("SELECT * FROM " + tablaBD + " WHERE nick='" + nombre + "'");
        String consulta = "INSERT INTO usuarios VALUES ('"+usuario.getNick()+"','"+usuario.getContrasena()+"','"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getTelefono()+"','"+usuario.getDireccion()+"','"+usuario.getTipo()+"')";
        db.ejecutarQuery(consulta);
        System.out.println(consulta);
        db.desconectar();
    }
    
    public void eliminarUsuario(Usuario usuario){
        db.conectar();
        String consulta = "delete from usuarios where nick like '"+usuario.getNick()+"'";
        db.ejecutarQuery(consulta);
        System.out.println(consulta);
        db.desconectar();
    }
    
    public void modificarDatosUsuario(Usuario usuario){
        /*UPDATE `usuarios` SET `contrasena` = 'a' WHERE `usuarios`.`nick` = 'amigo';*/
        db.conectar();
        String consulta = "update usuarios set contrasena = '"+usuario.getContrasena()+"', nombre = '"+usuario.getNombre()+"', apellidos = '"+usuario.getApellidos()+"', telefono = '"+usuario.getTelefono()+"', direccion = '"+usuario.getDireccion()+"', tipo = '"+usuario.getTipo()+"' where nick like '"+usuario.getNick()+"'";
        db.ejecutarQuery(consulta);
        System.out.println(consulta);
        db.desconectar();
    }
}
