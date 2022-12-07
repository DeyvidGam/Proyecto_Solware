package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.app.web.servicio.MovimientoServicio;



@Controller
public class MovimientoControlador {
	@Autowired
	private MovimientoServicio movimientoServicio;

	@GetMapping("/movimiento")

	public String listarmovimiento(Model modelo) {
		modelo.addAttribute("Movimiento", movimientoServicio.listarmovimiento());
		return "movimiento";
	}
	

}
