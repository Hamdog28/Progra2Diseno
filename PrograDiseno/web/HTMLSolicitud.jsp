<%@page import="proyectoresoluciones.negocio.Controlador"%>
<%@page import="proyectoresoluciones.datos.Solicitud"%>
<%@page import="progradiseno.negocio.*"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Solicitud</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">


  </head>
  <body>
    <% 
        Solicitud solicitud = new Solicitud();
            
                solicitud = (Solicitud)request.getAttribute("Solicitud");
            %>
 <div id="nav-placeholder">   
     
    <script src="//code.jquery.com/jquery.min.js"></script>
<script>
    
$.get("navbar.html", function(data){
    $("#nav-placeholder").replaceWith(data);
});

window.onload = function() {
        var myVal = document.getElementById("Estado").innerHTML;
        document.getElementById("esconder").style.display = 'none';
        if(myVal == "TRAMITADA") {
            document.getElementById("Resolucion").style.display = 'block'; 
        }else {
            document.getElementById("Resolucion").style.display = 'none'; 
        }
}
function resolucion() {
    window.open("ArchivoHtml.html");
}
</script>
 </div>   
    <div class="container">
            <div class="form-group" id="esconder">
          <input type="text" class="form-control" placeholder="Número de solicitud" name="Cod"value="<%=request.getAttribute("Codigo")%>">
        </div>
            <div class="row">
                <div class="col-md-6" >
                    <h1>Solicitud número <%=request.getAttribute("Codigo")%></h1>
                    <div class="form-group">
                        <label>Fecha</label>
                        <p name="Fecha"><%=solicitud.getFecha()%></p>
                    </div>
                    
                    <div class="form-group">
                        <label for="Id">Carné / Identificacion del Solicitante</label>
                        <p><%=solicitud.getIdSolicitante()%></p>
                    </div>

                    <div class="form-group">
                        <label for="Periodo">Periodo en el que se dio el problema</label>
                        <p><%= solicitud.getPeriodo()%></p>
                    </div>
                
                    <div class="form-group">
                        <label for="Curso">Curso </label>
                        <p><%= solicitud.getCodigoCurso()%></p>

                    </div>

                    <div class="form-group">
                        <label for="Grupo">Grupo </label>
                        <p><%= String.valueOf(solicitud.getGrupo())%></p>
                    </div>

                    <div class="form-group">
                        <label for="Descripcion">Descripción </label>
                        <p><%= solicitud.getDescripcion()%></p>
                    </div>
                    
                    <div class="form-group">
                        <label>Categoría </label>
                        <p name="Categoria"><%= solicitud.getSituacion().name()%></p>
                    </div>
                    
                    <div class="form-group">
                        <label>Estado </label>
                        <p id="Estado" name="Estado"><%= solicitud.getEstado().name()%></p>
                    </div>
                
                    
                
                </div>
                
                <div class="col-md-6">
                    <br>
                    <br>
                    <h3>Datos del estudiante</h3>
                    <div class="form-group">
                        <label for="Carne">Carné del Estudiante</label>
                        <p><%= String.valueOf(solicitud.getCarneEstudiante())%></p>
                    </div>

                    <div class="form-group">
                      <label for="Nombre">Nombre Completo </label>
                      <p><%= solicitud.getNombreEstudiante()%></p>
                    </div>

                    <div class="form-group">
                      <label for="Correo">Correo Electónico </label>
                      <p><%= solicitud.getCorreoEstudiante()%></p>
                    </div>

                    <div class="form-group">
                        <label for="Celular">Celular </label>
                        <p><%= String.valueOf(solicitud.getTelefonoEstudiante())%></p>
                    </div>
                
                 </div>
                
            
        
            </div>
                    <div id="Resolucion" name="Resolucion">
                        <button type="submit" class="btn btn-success" onclick="resolucion()">Ver Resolución</button>
                    </div>
                    <br>
        
    </div>
  </body>
</html>
