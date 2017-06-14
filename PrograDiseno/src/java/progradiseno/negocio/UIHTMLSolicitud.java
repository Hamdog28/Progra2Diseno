/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progradiseno.negocio;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MaríaLaura
 */
@WebServlet(name = "UIHTMLSolicitud", urlPatterns = {"/UIHTMLSolicitud"})
public class UIHTMLSolicitud extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            String identificacion = request.getParameter("Id");
            String nombre = request.getParameter("Nombre");
            String correo = request.getParameter("Correo");
            String celular = request.getParameter("Celular");
            
            String periodo = request.getParameter("Periodo");
            String curso = request.getParameter("Curso");
            String grupo = request.getParameter("Grupo");
            
            String descripcion = request.getParameter("Descripcion");
            out.write("id= "+identificacion+"\n\t");
            out.write("nombre= "+nombre+"\n\t");
            out.write("correo= "+correo+"\n\t");
            out.write("correo= "+celular+"\n\t");
            
            out.write("periodo= "+periodo+"\n\t");
            out.write("curso= "+curso+"\n\t");
            out.write("grupo= "+grupo+"\n\t");
            
            out.write("descripcion= "+descripcion+"\n\t");
            
        }catch(Exception e){
            
        }finally{ 
            out.close();
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
