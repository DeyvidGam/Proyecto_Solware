function validacion() {

  var nombres = document.getElementById("nombres").value;
  var apellidos = document.getElementById("apellidos").value;
  var Rol = document.getElementById("Rol").value;
  var Correo = document.getElementById("Correo").value;
  var Contraseña = document.getElementById("Contraseña").value;
  if (nombres=="") {
    alert('[ERROR] El campo "Nombre" debe completarse');

    }
  if (apellidos=="") {
    alert('[ERROR] El campo "Apellido" debe completarse');

    }

  if( Rol=="") {
    alert('[ERROR] El campo "ID Rol" debe completarse');

  }
  
  if( Correo=="" ) {
    alert('[ERROR] El campo "correo" debe completarse');

  }
  if( Contraseña == null || Contraseña == 0 ) {
    alert('[ERROR] El campo "Contraseña" debe completarse');
    }
  
  }
