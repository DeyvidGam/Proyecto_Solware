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

import com.app.web.entidad.Cliente;
import com.app.web.servicio.ClienteServicio;

@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;

	@GetMapping("/C_ClienteA")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Cliente", clienteServicio.listarclientes());
		return "C_ClienteA";
	}

	@GetMapping("/ClientesA")
	public String crearCliente(Model modelo) {
		Cliente cliente = new Cliente();
		modelo.addAttribute("Cliente", cliente);
		return "ClientesA";
	}

	@PostMapping("/C_ClienteA")
	public String guardarCliente(@ModelAttribute("Cliente") Cliente cliente) {
		clienteServicio.guardarCliente(cliente);
		return "redirect:/Solware2/home/C_ClienteA";
	}

	@GetMapping("/C_ClienteA/editar/{Identificacion}")
	public String Editar(@PathVariable Long Identificacion,Model modelo ) {
		modelo.addAttribute("Cliente", clienteServicio.obtenerClientePorId(Identificacion));
	    return "editar_cliente";
	}

	@PostMapping("/C_ClienteA/{Identificacion}")
	public String updateCliente(@PathVariable Long Identificacion, @ModelAttribute("Cliente") Cliente cliente, Model modelo) {
		Cliente clienteExistente = clienteServicio.obtenerClientePorId(Identificacion);
		clienteExistente.setIdentificacion(Identificacion);
		clienteExistente.setNombres(cliente.getNombres());
		clienteExistente.setApellidos(cliente.getApellidos());
		clienteExistente.setEmail(cliente.getEmail());
		clienteExistente.setTelefono(cliente.getTelefono());
		clienteServicio.updateCliente(clienteExistente);
		return "redirect:/Solware2/home/C_ClienteA";
	}
	
	@GetMapping("/C_ClienteA/{Identificacion}")
	public String deleteCliente(@PathVariable Long Identificacion) {
		
		clienteServicio.delete(Identificacion);
		return "redirect:/Solware2/home/C_ClienteA";
		
	}

}
