
function validacion(){

    var nombre = document.getElementById("nombre").value;
    var Proveedor = document.getElementById("CodigoProveedor").value;
    var Tamaño= document.getElementById("Tamaño").value;
    var Total= document.getElementById("Total").value;
    
    if (nombre=="") {
      alert('[ERROR] El campo "Nombre" debe completarse');
  
      }
    if (Proveedor=="") {
      alert('[ERROR] El campo "Proveedor" debe completarse');
  
      }
    if(Tamaño=="") {
      alert('[ERROR] El campo "Tamaño" debe completarse');
  
    }

    
    if( Total=="" ) {
      alert('[ERROR] El campo "Precio" debe completarse');
      }
    
    }