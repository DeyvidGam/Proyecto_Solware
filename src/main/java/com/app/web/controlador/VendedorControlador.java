package com.app.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class VendedorControlador {

	
	
	@GetMapping("/aa")
	public String aa(Model modelo) {
		return "aa";
	}
	
	@GetMapping("/PerfilV")
	public String PerfilV(Model modelo) {
		return "PerfilV";
	}
	@GetMapping("/Proveedores")
	public String Proveedores(Model modelo) {
		return "Proveedores";
	}
	
	
	
	@GetMapping("/Productos")
	public String Productos(Model modelo) {
		return "Productos";
	}
	
	@GetMapping("/Pedidos")
	public String Pedidos(Model modelo) {
		return "Pedidos";
	}

	@GetMapping("/ReportesV")
	public String ReportesV(Model modelo) {
		return "ReportesV";
	}
}
