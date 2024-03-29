package com.app.web.servicio;

import java.util.List;
import java.util.Optional;

import com.app.web.entidad.Usuario;

public interface UsuarioServicio {
	   	public List<Usuario> listarusuario();
	    public Usuario obtenerUsuarioPorId(Long ID_Usuario);
	    public Usuario guardarUsuario(Usuario usuario);
	    public Usuario updateUsuario(Usuario usuario);
	    public void delete(Long ID_Usuario);
	    public Optional<Usuario> obtenerCorreUsuario(String Correo);
		boolean existeCorreo(String correo);
	    
	
}