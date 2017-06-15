/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progradiseno.negocio;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try(PrintWriter out = response.getWriter()) {
            
            String identificacion = request.getParameter("Id");
            String nombre = request.getParameter("Nombre");
            String correo = request.getParameter("Correo");
            String celular = request.getParameter("Celular");
            String carne = request.getParameter("Carne");
            String periodo = request.getParameter("Periodo");
            String curso = request.getParameter("Curso");
            String grupo = request.getParameter("Grupo");
            //int IdGrupo = controladorViejo.obtenerIdGrupo(curso, periodo, Integer.parseInt(grupo));
            String descripcion = request.getParameter("Descripcion");
            
            Date date = new Date();
            String fecha= new SimpleDateFormat("yyyy-MM-dd").format(date);
            Situacion situacion = ERROR_NOTA;
            System.out.println(fecha);
            /*
            out.write("id= "+identificacion+"\n\t");
            out.write("nombre= "+nombre+"\n\t");
            out.write("correo= "+correo+"\n\t");
            out.write("correo= "+celular+"\n\t");
            
            out.write("periodo= "+periodo+"\n\t");
            out.write("curso= "+curso+"\n\t");
            out.write("grupo= "+grupo+"\n\t");
            
            out.write("descripcion= "+descripcion+"\n\t");
            */
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
            dtoSolicitud.setProfesor("5-5555-5555");
            dtoSolicitud.setArchivo("archivo");
            dtoSolicitud.setIdGrupo(1);
            
            controladorViejo.crearSolicitud(dtoSolicitud);
            System.out.println("hola");
            response.sendRedirect("HTMLSolicitud.html");
            return;
            
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
