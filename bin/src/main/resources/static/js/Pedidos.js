
function validacion() {

  var fecha = document.getElementById("fecha").value;
  var IdCliente = document.getElementById("IdCliente").value;
  var Total = document.getElementById("Total").value;
  var Cantidad = document.getElementById("Cantidad").value;
  var Subtotal = document.getElementById("Subtotal").value;
  var CodigoPedido = document.getElementById("CodigoPedido").value;
  var CodigoProducto = document.getElementById("CodigoProducto").value;

  if (fecha=="") {
    alert('[ERROR] El campo "fecha" debe completarse');

    }
  if (IdCliente=="") {
    alert('[ERROR] El campo "IdCliente" debe completarse');

    }
  if( Total=="") {
    alert('[ERROR] El campo "Total" debe completarse');

  }
  if( Cantidad == null || Cantidad == 0 ) {
    alert('[ERROR] El campo "Cantidad" debe completarse');
    }

  if( Subtotal=="" ) {
    alert('[ERROR] El campo "Subtotal" debe completarse');

  }
   if( CodigoPedido=="" ) {
    alert('[ERROR] El campo "CodigoPedido" debe completarse');

  }
   if( CodigoProducto=="" ) {
    alert('[ERROR] El campo "CodigoProducto" debe completarse');

  }

  }