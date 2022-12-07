
function validacion(){

    var nombre = document.getElementById("nombre").value;
    var Producto = document.getElementById("Producto").value;
    var Correo = document.getElementById("Correo").value;
    var telefono = document.getElementById("Telefono")
    var IDProducto= document.getElementById("IDProducto").value;
    
    if (nombre=="") {
      alert('[ERROR] El campo "Nombre" debe completarse');
  
      }
    if (Producto=="") {
      alert('[ERROR] El campo "Producto" debe completarse');
  
      }
    if(telefono=="") {
      alert('[ERROR] El campo "Telefono" debe completarse');
  
    }
    
    if( Correo=="" ) {
      alert('[ERROR] El campo "correo" debe completarse');
  
    }
    if( IDProducto=="" ) {
      alert('[ERROR] El campo "producto" debe completarse');
      }
    
    }