package com.app.web.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.web.entidad.Rol;
import com.app.web.entidad.Usuario;
import com.app.web.entidad.Venta;
import com.app.web.servicio.RolServicio;
import com.app.web.servicio.UsuarioServicio;



@Controller
@RequestMapping(path="/Solware2/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class UsuarioControlador {
	@Autowired
	private  UsuarioServicio usuarioServicio;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private  RolServicio rolServicio;
	@GetMapping("/ConsultarUs")

	public String listarusuario(Model modelo) {
		modelo.addAttribute("Usuario", usuarioServicio.listarusuario());
		return "ConsultarUs";
		
	}

	@GetMapping("/ConsultarUs/nuevo")
	public String crearUsuario(Model modelo) {
	    Usuario usuario = new Usuario();
	    usuario.setEstado(true); // establecer el estado en true

	    List<Rol> listaroles = rolServicio.listarrol();

	    modelo.addAttribute("Usuario", usuario);
	    modelo.addAttribute("roles", listaroles);

	    return "PerfilADMIN";
	}

	@PostMapping("/ConsultarUs")
	public String guardarUsuario(@ModelAttribute("Usuario") Usuario usuario, RedirectAttributes attributes) {
	    usuario.setEstado(true);
	    usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // encriptar la contraseña
	    attributes.addFlashAttribute("exitoso", "Registro Exitoso");
	    usuarioServicio.guardarUsuario(usuario);
	    return "redirect:/Solware2/Admin/ConsultarUs/nuevo";
	}

	@GetMapping("/ConsultarUs/editar/{ID_Usuario}")
	public String Editar(@PathVariable Long ID_Usuario, Model modelo) {
	    Usuario usuario = usuarioServicio.obtenerUsuarioPorId(ID_Usuario);
	    if(!usuario.isEstado()) { // Verifica si el usuario está inactivo
	        return "redirect:/Solware2/Admin/ConsultarUs";
	    }
	    modelo.addAttribute("Usuario", usuario);
	    List<Rol> listaroles = rolServicio.listarrol();
	    modelo.addAttribute("roles", listaroles);
	    return "editar_usuario";
	}

	@PostMapping("/ConsultarUs/{ID_Usuario}")
	public String updateUsuario(@PathVariable Long ID_Usuario, @ModelAttribute("Usuario") Usuario usuario, Model modelo) {
		Usuario usuarioExistente = usuarioServicio.obtenerUsuarioPorId(ID_Usuario);
		usuarioExistente.setID_Usuario(ID_Usuario);
		usuarioExistente.setNombre(usuario.getNombre());
		usuarioExistente.setApellido(usuario.getApellido());
		usuarioExistente.setCorreo(usuario.getCorreo());
		usuarioExistente.setTelefono(usuario.getTelefono());
		usuarioExistente.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
		usuarioServicio.updateUsuario(usuarioExistente);
		return "redirect:/Solware2/Admin/ConsultarUs";
	}
	
	@GetMapping("/ConsultarUs/{ID_Usuario}")
	public String deleteUsuario(@PathVariable Long ID_Usuario) {
		usuarioServicio.delete(ID_Usuario);
		return "redirect:/Solware2/Admin/ConsultarUs";
	}
	
	
	
	@PostMapping("/Usuario/estado")
	public String cambiarEstadoVenta(@RequestParam("idUsuario") Long idUsuario, Model modelo, RedirectAttributes attributes) {
		Usuario usuario = usuarioServicio.obtenerUsuarioPorId(idUsuario);
	
		usuario.setEstado(!usuario.isEstado()); // Cambia el estado actual de la venta
		usuarioServicio.guardarUsuario(usuario); // Actualiza la venta en la base de datos
		 return "redirect:/Solware2/Admin/ConsultarUs"; // Redirige a la página de lista de ventas
	} 

}
