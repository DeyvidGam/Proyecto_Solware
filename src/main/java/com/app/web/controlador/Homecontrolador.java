package com.app.web.controlador;
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
	
	@GetMapping("/Nosotros")
	public String Nosotros(Model modelo) {
		return "Nosotros";
	}
	@GetMapping("/Servicios")
	public String Servicios(Model modelo) {
		return "Servicios";
	}

	@GetMapping("/Admin")
	public String Admin(Model modelo) {
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
	@GetMapping("/Quienesmos")
	public String Quienesmos(Model modelo) {
		return "Quienesmos";
	}
	@GetMapping("/vision")
	public String vision(Model modelo) {
		return "vision";
	}
	@GetMapping("/mision")
	public String mision(Model modelo) {
		return "mision";
	}
}