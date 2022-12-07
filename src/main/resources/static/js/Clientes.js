function validacion() {

    var nombres = document.getElementById("nombres").value;
    var apellidos = document.getElementById("apellidos").value;
    var IDENTIFICACION = document.getElementById("IDENTIFICACION").value;
    var Correo = document.getElementById("Correo").value;
 
    if( IDENTIFICACION=="") {
        alert('[ERROR] El campo "IDENTIFICACION" debe completarse');
    
      }
    if (nombres=="") {
      alert('[ERROR] El campo "Nombre" debe completarse');
  
      }
    if (apellidos=="") {
      alert('[ERROR] El campo "Apellido" debe completarse');
  
      }
  
  
    
    if( Correo=="" ) {
      alert('[ERROR] El campo "correo" debe completarse');
  
    }
  
    
    }
  