package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.web.entidad.Cliente;
import com.app.web.servicio.ClienteServicio;

@Controller
@RequestMapping(path="/Solware2/Vendedor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ClienteControladorV {

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping("/C_Cliente")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Cliente", clienteServicio.listarclientes());
		return "C_Cliente";
	}

	@GetMapping("/C_Cliente/nuevo")
	public String crearCliente(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("Cliente", cliente);
		return "Clientes";
	}

	@PostMapping("/C_Cliente")
	public String guardarCliente(@ModelAttribute("Cliente") Cliente cliente, RedirectAttributes attributes) {
		attributes.addFlashAttribute("exitoso", " Registro Exitoso");
		clienteServicio.guardarCliente(cliente);
		return "redirect:/Solware2/Vendedor/C_Cliente/nuevo";
	}

	@GetMapping("/C_Cliente/editar/{Identificacion}")
	public String Editar(@PathVariable Long Identificacion,Model modelo ) {
		modelo.addAttribute("Cliente", clienteServicio.obtenerClientePorId(Identificacion));
	    return "editar_cliente";
	}

	@PostMapping("/C_Cliente/{Identificacion}")
	public String updateCliente(@PathVariable Long Identificacion, @ModelAttribute("Cliente") Cliente cliente, Model modelo) {
		Cliente clienteExistente = clienteServicio.obtenerClientePorId(Identificacion);
		clienteExistente.setIdentificacion(Identificacion);
		clienteExistente.setNombres(cliente.getNombres());
		clienteExistente.setApellidos(cliente.getApellidos());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setTelefono(cliente.getTelefono());
		clienteServicio.updateCliente(clienteExistente);
		return "redirect:/Solware2/Vendedor/C_Cliente";
	}
	
	@GetMapping("/C_Cliente/{Identificacion}")
	public String deleteCliente(@PathVariable Long Identificacion) {
		clienteServicio.delete(Identificacion);
		return "redirect:/Solware2/Vendedor/C_Cliente";
		
	}

}
