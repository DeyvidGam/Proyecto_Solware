package com.app.web.controlador;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(path="/Solware2/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class AdminControlador {
		
	@GetMapping("/Admin")
	public String Admin(Authentication authentication, Model model) {
		String nombreUsuario = authentication.getName();
        model.addAttribute("nombreUsuario", nombreUsuario);
		return "Admin";
	}
	@GetMapping("/ReportesVA")
	public String ReportesVA(Model modelo) {
		return "ReportesVA";
	}
	@GetMapping("/ReportesIn")
	public String ReportesIn(Model modelo) {
		return "ReportesIn";
	}
	@GetMapping("/ReportesPro")
	public String ReportesPro(Model modelo) {
		return "ReportesPro";
	}
	
}