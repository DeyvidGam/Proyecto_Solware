package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.web.servicio.EstadoServicio;



public class EstadoControlador {

	
	@Autowired
	private EstadoServicio estadoServicio;

	@GetMapping("/estado")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Estado", estadoServicio.listarestados());
		return "estado";
	}
}
