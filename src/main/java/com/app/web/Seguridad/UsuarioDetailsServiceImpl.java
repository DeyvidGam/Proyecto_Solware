package com.app.web.Seguridad;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Usuario;
import com.app.web.repositorio.UsuarioRepositorio;
import com.app.web.servicio.UsuarioServicio;
import java.util.Optional;
@Service("usuarioDetailsService")
public class UsuarioDetailsServiceImpl implements UserDetailsService{

	
	@Autowired
    private UsuarioRepositorio  usuarioRepository;
	
	@Autowired
    private UsuarioServicio  usuarioServicio;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<Usuario> usuarioOptional = usuarioRepository.findByCorreo(username);
	    Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException(username));

	    List<GrantedAuthority> roles = new ArrayList<>();
	    roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre_Rol()));

	    return new User(usuario.getCorreo(), usuario.getContrasena(), roles);
	}

}
