/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Teru
 */


/**
 * Clase que realiza la conexion de la base de datos y ejecuta los métodos para
 * realizar y ejecutar consultas
 * @author Vicente Torres Sanz
 */
public class BaseDatos {


    private String USUARIO = "root";

    private String PASSWORD = "";

    private final String NOMBREBD = "comercio";

    private String URL = "jdbc:mysql://localhost/" + NOMBREBD + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

    private final static String DRIVER = "com.mysql.jdbc.Driver";

    private Connection conn = null;

    private Statement stmt = null;
   

    /**
     * Constructor vacio
     */
    public BaseDatos () {
    }

    /**
     * Método que dado un String en el cual se encuentra una consulta SQL
     * realiza dicha consulta sobre la base de datos
     * @param consulta String que representa la consulta SQL que se quiere realizar
     * @return ResultSet con los resultados de la consulta
     */
    public ResultSet ejecutarSelect (String consulta) {
        try {
            stmt = conn.createStatement();
            //Se ejecuta la consulta
            ResultSet results = stmt.executeQuery(consulta);
            return results;
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return null;
    }

    /**
     * Método que dado un String en el cual se encuentra una consulta SQL
     * realiza dicha consulta sobre la base de datos
     * @param String que representa la consulta SQL que se quiere realizar
     */
    public void ejecutarQuery (String consulta) {
        try {
            stmt = conn.createStatement();
            stmt.execute(consulta);
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
    }

    /**
     * Método que realiza la conexion con la base de datos
     */
    public void conectar () {
        try {
            Class.forName(DRIVER).newInstance();
            //Get a connection
            conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que realiza la desconexión con la base de datos
     */
    public void desconectar () {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}


