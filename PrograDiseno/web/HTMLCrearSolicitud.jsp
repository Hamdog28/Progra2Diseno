<%@page import="java.util.ArrayList"%>
<%@page import="proyectoresoluciones.negocio.*"%>
<%@page import="proyectoresoluciones.datos.*"%>
<%@page import="progradiseno.negocio.*"%>
<jsp:include page="/UIHTMLCrearSolicitud" />

<!DOCTYPE html>
<html lang="en">
  <head>
     
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Ingresar Solicitud</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  
 <div id="nav-placeholder">   

    <script src="//code.jquery.com/jquery.min.js"></script>
<script>
    
$.get("navbar.html", function(data){
    $("#nav-placeholder").replaceWith(data);
});
</script>

 </div>      
      <br>
    <div class="container">
        <div class="panel panel-custom-horrible-red">
            <div class="panel-heading ">
                <h1 >Solicitud</h1>
            </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        

        <div class="panel-body">
            <form action="UIHTMLCrearSolicitud" method="POST" >
                
                <%
                    ArrayList<Curso> cursos = (ArrayList<Curso>) request.getAttribute("listaC");
                    ArrayList<String> grupos = (ArrayList<String>) request.getAttribute("listaG");
                %>

                
                <div class="form-group">
                    <label for="Id">Carné / Identificacion del Solicitante</label><font color="red"> *</font>
                  <input type="text" class="form-control" id="Id" name="Id" required>
                </div>

                <div class="form-group">
                    <label for="Periodo">Periodo en el que se dio el problema</label><font color="red"> *</font>
                  <input type="text" class="form-control" id="Periodo" name="Periodo" required>
                </div>
                
                <div class="form-group">
                    <label for="Curso">Curso </label>
                  
                    <select class="form-control" id="Curso" name="Curso" >
                    <%
                        for(Curso c : cursos) { %>
                        <option value="<%=c.getCodigo()%>"><%=c.getCodigo()%></option>
                        <% 
                        }
                    %>
                        
                    
                  </select>
                </div>




                <div class="form-group">
                    <label for="Grupo">Grupo </label>
                  <input type="text" class="form-control" id="Grupo" name="Grupo" required>
                </div>

                <div class="form-group">
                    <label for="Descripcion">Descripción </label><font color="red"> *</font>
                    <textarea class="form-control" id="Descripcion" name="Descripcion" required></textarea>
                </div>
                <br>
                <br>
                <h2>Datos del estudiante</h2>
                <br>
                <div class="form-group">
                    <label for="Carne">Carné del Estudiante</label><font color="red"> *</font>
                  <input type="text" class="form-control" id="Carne" name="Carne" required>
                </div>

                <div class="form-group">
                  <label for="Nombre">Nombre Completo </label><font color="red"> *</font>
                  <input type="text" class="form-control" id="Nombre" name="Nombre" required>
                </div>

                <div class="form-group">
                  <label for="Correo">Correo Electónico </label><font color="red"> *</font>
                  <input type="email" class="form-control" id="Correo" name="Correo" required>
                </div>

                <div class="form-group">
                    <label for="Celular">Celular </label><font color="red"> *</font>
                  <input type="text" class="form-control" id="Celular" name="Celular" required>
                </div>
                <br>
                <div class="form-group">
                    <label for="Evidencia">Evidencia </label>
                  <input type="file" class="form-control" id="Evidencia" name="Evidencia">
                </div>

                <button type="submit" class="btn btn-success" name="Enviar">Enviar</button>
            </form>
            </div>
    </div>
        </div>

  </body>
</html>
