/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BaseDatos.UsuarioDB;
import Clases.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DAW
 */
public class ModificarDatosUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nick = request.getParameter("nick");
            String contrasena = request.getParameter("contrasena");
            String contrasena1 = request.getParameter("contrasena1");
            String contrasena2 = request.getParameter("contrasena2");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion"); 
            String tipo = request.getParameter("tipo"); 
            
            UsuarioDB objetoDB = new UsuarioDB();
            if(contrasena1.equals(contrasena2) && contrasena.equals(objetoDB.getUsuario(nick).getContrasena())){
                if(contrasena1.length() > 5){
                    objetoDB.modificarDatosUsuario(new Usuario(nick, contrasena1, nombre, apellidos, telefono, direccion, tipo));
                    response.sendRedirect(response.encodeRedirectURL("index.jsp"));
                }else{
                    /*La contraseña no cumple longitud*/
                }                
            }
            else if(contrasena1.equals("") && contrasena2.equals("")){
                objetoDB.modificarDatosUsuario(new Usuario(nick, objetoDB.getUsuario(nick).getContrasena(), nombre, apellidos, telefono, direccion, tipo));
                response.sendRedirect(response.encodeRedirectURL("index.jsp"));
            }
            else{
                /*Las tres contraseñas no eran correctas, vieja o nuevas*/
                response.sendRedirect(response.encodeRedirectURL("perfil.jsp"));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
