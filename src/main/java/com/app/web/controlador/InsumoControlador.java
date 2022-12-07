package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.app.web.entidad.Insumo;
import com.app.web.servicio.InsumoServicio;



@Controller
public class InsumoControlador {
	@Autowired
	private InsumoServicio insumoServicio;
	
	@GetMapping("/insumo")

	public String listarinsumo(Model modelo) {
		modelo.addAttribute("Insumo", insumoServicio.listarinsumo());
		return "insumo";
	}
	
	@GetMapping("/insumo/nuevo")
	public String crearInsumo(Model modelo) {
		Insumo insumo = new Insumo();
		modelo.addAttribute("Insumo", insumo);
		return "crearInsumo";

	}

	@PostMapping("/insumo")
	public String guardarInsumo(@ModelAttribute("Insumo") Insumo insumo) {
		insumoServicio.guardarInsumo(insumo);
		return "redirect:/insumo";
	}
	@GetMapping("/insumo/editar/{ID_Insumo}")
	public String Editar(@PathVariable Long ID_Insumo,Model modelo ) {
		modelo.addAttribute("Insumo", insumoServicio.obtenerInsumoPorId(ID_Insumo));
	    return "editar_insumo";
	}
	
	@PostMapping("/insumo/{ID_Insumo}")
	public String updateInsumo(@PathVariable Long ID_Insumo, @ModelAttribute("Insumo") Insumo insumo, Model modelo) {
		Insumo insumoExistente = insumoServicio.obtenerInsumoPorId(ID_Insumo);
		insumoExistente.setID_Insumo(ID_Insumo);
		insumoExistente.setNombre_Material(insumo.getNombre_Material());
		insumoExistente.setEstadoInsumo(insumo.getEstadoInsumo());
		insumoServicio.updateInsumo(insumoExistente);
		return "redirect:/insumo";
	}
	
	@GetMapping("/ruta/{ID_Insumo}")
	public String deleteInsumo(@PathVariable Long ID_Insumo) {
		
		insumoServicio.delete(ID_Insumo);
		return "redirect:/insumo";
		
	}
	
}
