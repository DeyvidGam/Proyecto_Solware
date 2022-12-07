package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.web.entidad.Detalle_Produccion;
import com.app.web.servicio.Detalle_ProduccionServicio;

@Controller
public class Detalle_ProduccionControlador {
	@Autowired
	private Detalle_ProduccionServicio detalle_ProduccionServicio;

	
	@GetMapping("/detalle_Produccion")

	public String listardetalle_Produccion(Model modelo) {
		modelo.addAttribute("Detalle_Produccion", detalle_ProduccionServicio.listardetalle_Produccion());
		return "detalle_Produccion";
	}
	
	@GetMapping("/detalle_Produccion/nuevo")
	public String crearDetalle_Produccion(Model modelo) {
		Detalle_Produccion detalle_Produccion = new Detalle_Produccion();
		modelo.addAttribute("Detalle_Produccion", detalle_Produccion);
		return "creardetalle_Produccion";

	}
	
	@PostMapping("/detalle_Produccion")
	public String guardarDetalle_Produccion(@ModelAttribute("Detalle_Produccion") Detalle_Produccion detalle_Produccion) {
		detalle_ProduccionServicio.guardarDetalle_Produccion(detalle_Produccion);
		return "redirect:/detalle_Produccion";
	}
	
	@GetMapping("/detalle_Produccion/editar/{ID_Detalle_Produccion}")
	public String Editar(@PathVariable Long ID_Detalle_Produccion,Model modelo ) {
		modelo.addAttribute("Detalle_Produccion", detalle_ProduccionServicio.obtenerDetalle_ProduccionPorId(ID_Detalle_Produccion));
	    return "editar_detalle_Produccion";
	}
	@PostMapping("/detalle_Produccion/{ID_Detalle_Produccion}")
	public String updateDetalle_Produccion(@PathVariable Long ID_Detalle_Produccion, @ModelAttribute("Detalle_Produccion") Detalle_Produccion detalle_Produccion, Model modelo) {
		Detalle_Produccion detalle_ProduccionExistente = detalle_ProduccionServicio.obtenerDetalle_ProduccionPorId(ID_Detalle_Produccion);
		detalle_ProduccionExistente.setID_Detalle_Produccion(ID_Detalle_Produccion);
		detalle_ProduccionExistente.setInsumo(detalle_Produccion.getInsumo());
		detalle_ProduccionExistente.setProduccion(detalle_Produccion.getProduccion());
		detalle_ProduccionExistente.setCantidad(detalle_Produccion.getCantidad());
		detalle_ProduccionServicio.updateDetalle_Produccion(detalle_ProduccionExistente);
		return "redirect:/detalle_Produccion";
	}
	
	@GetMapping("/detalle_Produccion/{ID_Detalle_Produccion}")
	public String deleteDetalle_Produccion(@PathVariable Long ID_Detalle_Produccion) {
		
		detalle_ProduccionServicio.delete(ID_Detalle_Produccion);
		return "redirect:/detalle_Produccion";
		
	}
	
}
