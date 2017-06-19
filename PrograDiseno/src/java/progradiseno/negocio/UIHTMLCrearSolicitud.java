/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progradiseno.negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyectoresoluciones.negocio.*;
import proyectoresoluciones.datos.*;
import static proyectoresoluciones.datos.Situacion.ERROR_NOTA;


@WebServlet(name = "UIHTMLCrearSolicitud", urlPatterns = {"/UIHTMLCrearSolicitud"})
public class UIHTMLCrearSolicitud extends HttpServlet {
    private DTOSolicitud dtoSolicitud = new DTOSolicitud();
    Controlador controladorViejo = new Controlador();
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
                String carne = request.getParameter("Carne");
                String periodo = request.getParameter("Periodo");
                String curso = request.getParameter("Curso");
                String grupo = request.getParameter("Grupo");
                int IdGrupo = controladorViejo.obtenerIdGrupo(curso, periodo, Integer.parseInt(grupo));
                String descripcion = request.getParameter("Descripcion");
                String evidencia = request.getParameter("Evidencia");

                Date date = new Date();
                String fecha= new SimpleDateFormat("yyyy-MM-dd").format(date);
                Situacion situacion = ERROR_NOTA;
              
                dtoSolicitud.setFecha(fecha);
                dtoSolicitud.setCodigoCurso(curso);
                dtoSolicitud.setSituacion(situacion);
                dtoSolicitud.setPeriodo(periodo);
                dtoSolicitud.setIdentificacion(carne);
                dtoSolicitud.setDescripcion(descripcion);
                dtoSolicitud.setNombre(nombre);
                dtoSolicitud.setCorreoElectronico(correo);
                dtoSolicitud.setTelefono(celular);
                dtoSolicitud.setIdSolicitante(identificacion);
                dtoSolicitud.setGrupo(Integer.parseInt(grupo));
                dtoSolicitud.setIdGrupo(IdGrupo);
                dtoSolicitud.setArchivo(evidencia);

                controladorViejo.crearSolicitud(dtoSolicitud);
                request.setAttribute("Cod",controladorViejo.obtenerUltimaSolicitud());
                request.setAttribute("Codigo", -1);
                request.getRequestDispatcher("HTMLInicio.jsp").forward(request, response); 
            
            
            
        }catch(Exception e){
            System.out.println("ERROR");
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
        
        ArrayList<Curso> cursos = llenarListaCursos();
            request.setAttribute("listaC",cursos);
            return;
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

    private ArrayList<Curso> llenarListaCursos() {
        
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        cursos = controladorViejo.cargarCursos();
        
        return cursos;
    }

    
}
