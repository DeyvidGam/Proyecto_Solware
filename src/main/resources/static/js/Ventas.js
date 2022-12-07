
function validacion() {

  var fecha = document.getElementById("fecha").value;
  var CodigoPedido = document.getElementById("CodigoPedido").value;
  var TipoPago = document.getElementById("TipoPago").value;
  var Total = document.getElementById("Total").value;

  if (fecha=="") {
    alert('[ERROR] El campo "fecha" debe completarse');

    }

   if( CodigoPedido=="" ) {
    alert('[ERROR] El campo "CodigoPedido" debe completarse');

  }
   if( TipoPago== null) {
    alert('[ERROR] El campo "TipoPago" debe completarse');

  }
if( Total=="") {
    alert('[ERROR] El campo "Total" debe completarse');

  }
}  