package com.app.web.controlador;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class Homecontrolador {
	
	@GetMapping("/index")
	public String mostrarpagina(Model modelo) {
		return "index";
	}
	 
	@GetMapping("/inicioSesion")
	public String inicioSesion(Model modelo) {
		return "inicioSesion";
	}
	
}