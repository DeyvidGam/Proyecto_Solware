//package com.app.web.Seguridad;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.app.web.entidad.Usuario;
//import com.app.web.repositorio.UsuarioRepositorio;
//import com.app.web.servicio.UsuarioServicio;
//
//@Service
//public class UsuarioDetailsServiceImpl implements UserDetailsService{
//
//	
//	@Autowired
//    private UsuarioRepositorio  usuarioRepository;
//	
//	@Autowired
//    private UsuarioServicio  usuarioServicio;
// 
//    @Override
//    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
//        Usuario usuario = usuarioRepository.findByCorreo(correo);
//        if (usuario == null) {
//            throw new UsernameNotFoundException(correo);
//        }
//        List<GrantedAuthority> roles = new ArrayList<>();
//        roles.add(new SimpleGrantedAuthority(usuario.getRol().getNombre_Rol()));
//        return new User(usuario.getCorreo(), usuario.getContrasena(), roles);
//    }
//}
