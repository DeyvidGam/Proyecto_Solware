package com.app.web.controlador;
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

import com.app.web.entidad.Produccion;
import com.app.web.servicio.ProduccionServicio;

@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class OperarioControlador {
	@Autowired
	private ProduccionServicio produccionServicios; 
	
	@GetMapping("/InicioP")
	public String InicioP(Model modelo) {
		return "InicioP";
	}
	@GetMapping("/PerfilO")
	public String PerfilO(Model modelo) {
		return "PerfilO";
	}
	@GetMapping("/ReportesPOperario")
	public String ReportesPOperario(Model modelo) {
		return "ReportesPOperario";
	}
	
	@GetMapping("/ConsultarProduccion")

	public String listarproduccionO(Model modelo) {
		modelo.addAttribute("Produccion", produccionServicios.listarproduccion());
		return "ConsultarProduccion";
	}
	@GetMapping("/ConsultarProduccion/editar/{ID_Produccion}")
	public String EditarO(@PathVariable Long ID_Produccion,Model modelo ) {
		modelo.addAttribute("Produccion", produccionServicios.obtenerProduccionPorId(ID_Produccion));
	    return "editar_Produccion";
	}
	
	@PostMapping("/ConsultarProduccion/{ID_Produccion}")
	public String updateProduccionO(@PathVariable Long ID_Produccion, @ModelAttribute("Produccion") Produccion produccion, Model modelo) {
		Produccion produccionExistente = produccionServicios.obtenerProduccionPorId(ID_Produccion);
		produccionExistente.setID_Produccion(ID_Produccion);
		produccionExistente.setOperario(produccion.getOperario());
		produccionExistente.setEstado_Produccion(produccion.getEstado_Produccion());
		produccionExistente.setFecha_Inicio(produccion.getFecha_Inicio());
		produccionExistente.setCantidad(produccion.getCantidad());
		produccionExistente.setFecha_Fin(produccion.getFecha_Fin());
		produccionExistente.setPedido(produccion.getPedido());
		
		produccionServicios.updateProduccion(produccionExistente);
		return "redirect:/Solware2/ConsultarProduccion";
	}
}