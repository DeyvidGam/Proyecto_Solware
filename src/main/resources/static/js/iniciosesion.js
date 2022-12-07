function validacion(){

    var Usuario = document.getElementById('Usuario').value;
    var Contraseña = document.getElementById('Contraseña').value
    var Rol = document.getElementById('Rol').value;


    if(Usuario==""){
        alert('Error Debe ingresar Un nombre de usuario')
    }
    if(Contraseña==""){
        alert('Error Debe ingresar Una Contraseña')
    }
    if(Rol==""){
        alert('Error Debe seleccionar un Rol')
        return false;
    }

    if (Usuario == "Deyvid" && Contraseña == "Deyvid123" && Rol=="Administrador"){
        alert ("INGRESO EXITOSO");
        window.location="/Solware2/home/Admin";
        return true;
    }if (Usuario == "Carlos" && Contraseña == "Carlos123" && Rol=="Vendedor"){
        alert ("INGRESO EXITOSO");
        window.location="/Solware2/aa";
        return true;
    }if (Usuario == "Stivens" && Contraseña == "Stivens123" && Rol=="Operario"){
        alert ("INGRESO EXITOSO");
        window.location="/Solware2/InicioP";
        return true;
    }else{
        alert("Su Usuario, Contraseña o Rol son incorrectos");
        return false
    }
}
function recordar(){

    var Usuario = document.getElementById('Usuario').value;


    if(Usuario==""){
        alert('Error Debe ingresar una direccion de correo electronico')
    }
     else{
     alert ("ENVIO EXITOSO");
        window.location="InicioSesion.html";
        return true;
}

}




