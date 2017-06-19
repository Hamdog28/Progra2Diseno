/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progradiseno.negocio;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyectoresoluciones.datos.*;
import proyectoresoluciones.negocio.Controlador;

/**
 *
 * @author MaríaLaura
 */
@WebServlet(name = "UIHTMLSolicitud", urlPatterns = {"/UIHTMLSolicitud"})
public class UIHTMLSolicitud extends HttpServlet {
    Controlador controladorViejo = new Controlador();
    Solicitud solicitud = new Solicitud();
    Resolucion resolucion = new Resolucion();
    int codigo;


   
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
            codigo = parseInt(request.getParameter("Codigo"));
            
            solicitud = controladorViejo.consultarSolicitud(codigo);
            request.setAttribute("Solicitud",solicitud);
            
            
            if(solicitud.getIdSolicitante()!=null ){
                request.setAttribute("Codigo",codigo);
                if(solicitud.getEstado().name()=="TRAMITADA"){
                    //Aqui va el generar html
                }
                request.getRequestDispatcher("HTMLSolicitud.jsp").forward(request, response); 
            }else
            {
                request.setAttribute("Codigo",0);
                request.getRequestDispatcher("HTMLInicio.jsp").forward(request, response); 
            }
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
