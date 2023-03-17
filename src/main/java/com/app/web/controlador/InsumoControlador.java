package com.app.web.controlador;

import java.util.List;

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

import com.app.web.entidad.Insumo;
import com.app.web.servicio.InsumoServicio;

@Controller
@RequestMapping(path="/Solware2/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})

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
		return "CrearInsumo";

	}
	  @GetMapping("/consultar-stock")
	    public String consultarStock(Model model) {
	        List<Insumo> insumos = insumoServicio.listarinsumo();
	        model.addAttribute("insumos", insumos);
	        return "stock-insumos";
	    }

	@PostMapping("/insumo")
	public String guardarInsumo(@ModelAttribute("Insumo") Insumo insumo) {
		insumoServicio.guardarInsumo(insumo);
		return "redirect:/Solware2/Admin/ModuloInventario";
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
		insumoExistente.setEstado_Insumo(insumo.getEstado_Insumo());
		insumoExistente.setDisponible(insumo.getDisponible());
		insumoServicio.updateInsumo(insumoExistente);
		return "redirect:/insumo";
	}
	
	@GetMapping("/eliminarinsumo/{ID_Insumo}")
	public String deleteInsumo(@PathVariable Long ID_Insumo) {	
		insumoServicio.delete(ID_Insumo);
		return "redirect:/Solware2/Admin/ModuloInventario";
		
	}
	
}
