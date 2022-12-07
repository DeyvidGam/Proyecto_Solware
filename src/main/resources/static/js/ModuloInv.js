 function Validar() {

  var IDProducto = document.getElementById("IDProducto").value;
  var NombreMaterial = document.getElementById("NombreMaterial").value;
  var Estado = document.getElementById("Estado").value;
  if (IDProducto=="") {
    alert('[ERROR] El campo "IDProducto" debe completarse');

    }
  if (NombreMaterial=="") {
    alert('[ERROR] El campo "NombreMaterial" debe completarse');

    }

  if( Estado=="") {
    alert('[ERROR] El campo "Estado" debe completarse');

  }
}
function validacion() {

  var fecha = document.getElementById("fecha").value;
  var IdInsumo = document.getElementById("IdInsumo").value;
  var Movimiento = document.getElementById("Movimiento").value;
  var Descripcion = document.getElementById("Descripcion").value;
  var Cantidad = document.getElementById("Cantidad").value;
  if (fecha=="") {
    alert('[ERROR] El campo "fecha" debe completarse');

    }
  if (IdInsumo=="") {
    alert('[ERROR] El campo "IdInsumo" debe completarse');

    }

  if( Movimiento=="") {
    alert('[ERROR] El campo "Movimiento" debe completarse');

  }
  
  if( Descripcion=="" ) {
    alert('[ERROR] El campo "Descripcion" debe completarse');

  }
  if( Cantidad == null || Cantidad == 0 ) {
    alert('[ERROR] El campo "Cantidad" debe completarse');
    }

  }

 
  