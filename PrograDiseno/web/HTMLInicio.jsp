
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        
        <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <script src="//code.jquery.com/jquery.min.js"></script>
<div id="nav-placeholder">   
    <script src="//code.jquery.com/jquery.min.js"></script>
<script>
    
$.get("navbar.html", function(data){
    $("#nav-placeholder").replaceWith(data);
});

window.onload = function() {
    document.getElementById("esconder").style.display = 'none';
        var myVal = document.getElementById("codigo").innerHTML;
        var myVal2 = document.getElementById("Cod").innerHTML;
        if(myVal == 0) {
            alert("El número de solicitud ingresado no coincide con ninguna solicitud"); 
        }
        else if(myVal==-1){
            alert("El número su solicitud es: " + myVal2); 
        }
}
</script>

 </div>    
<div class="container">
        <div class="jumbotron">
  <h1>Bienvenido al sistema de reportes de inconsistencias</h1>
  <br>
  <br>
  <br>
  <p><a class="btn btn-success btn-lg" href="HTMLCrearSolicitud.jsp" role="button">Ingresar solicitud</a></p>
</div>
        
        </div>
        
        <div id="esconder">
            <p id="codigo"><%=request.getAttribute("Codigo")%></p>
            <p id="Cod"><%=request.getAttribute("Cod")%></p>
        </div>
    </body>
</html>
