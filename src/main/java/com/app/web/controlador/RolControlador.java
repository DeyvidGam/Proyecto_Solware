package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.servicio.RolServicio;


@Controller
public class RolControlador {
	@Autowired
	private RolServicio rolServicio;

	@GetMapping("/rol")

	public String listarrol(Model modelo) {
		modelo.addAttribute("Rol", rolServicio.listarrol());
		return "rol";
	}
}
