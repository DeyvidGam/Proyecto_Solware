package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;
import java.util.Optional;
@Service
public class UsuarioServicioImp implements UsuarioServicio{
	 @Autowired
	    private UsuarioRepositorio usuarioRepositorio;
		@Override
		public List<Usuario> listarusuario() {
			return usuarioRepositorio.findAll();
		}

		@Override
		public Usuario obtenerUsuarioPorId(Long ID_Usuario) {
			return usuarioRepositorio.findById(ID_Usuario).get();
		}

		@Override
		public Usuario guardarUsuario(Usuario usuario) {
			return usuarioRepositorio.save(usuario);
		}

		@Override
		public Usuario updateUsuario(Usuario usuario) {
			return usuarioRepositorio.save(usuario);
		}

		@Override
		public void delete(Long ID_Usuario) {
			usuarioRepositorio.deleteById(ID_Usuario);
		}

		@Override
		public Optional<Usuario> obtenerCorreUsuario(String correo) {
		    return usuarioRepositorio.findByCorreo(correo);
		}
		@Override
	    public boolean existeCorreo(String correo) {
	        return usuarioRepositorio.findByCorreo(correo).isPresent();
	    }
}
