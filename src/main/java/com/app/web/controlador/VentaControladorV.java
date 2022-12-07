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

import com.app.web.entidad.Venta;
import com.app.web.servicio.VentaServicio;



@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class VentaControladorV {
	

	@Autowired
	private VentaServicio ventaServicio;

	@GetMapping("/ConsultarV")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Venta", ventaServicio.listarventas());
		return "ConsultarV";
	}

	@GetMapping("/ConsultarV/nuevo")
	public String crearCliente(Model modelo) {
		Venta venta = new Venta();
		modelo.addAttribute("Venta", venta);
		return "ventas";

	}

	@PostMapping("/ConsultarV")
	public String guardarCliente(@ModelAttribute("Venta") Venta venta) {
		ventaServicio.guardarVenta(venta);
		return "redirect:/Solware2/home/ConsultarV";
	}

	@GetMapping("/venta/editar/{ID_Venta}")
	public String Editar(@PathVariable Long ID_Venta,Model modelo ) {
		modelo.addAttribute("Cliente", ventaServicio.obtenerVentaPorId(ID_Venta));
	    return "editar_venta";
	}

	@PostMapping("/venta/{ID_Venta}")
	public String updateCliente(@PathVariable Long ID_Venta, @ModelAttribute("Venta") Venta venta, Model modelo) {
		Venta ventaExistente = ventaServicio.obtenerVentaPorId(ID_Venta);
		ventaExistente.setID_Venta(ID_Venta);
		ventaExistente.setFechaYHora(venta.getFechaYHora());
		ventaExistente.setModo_Pago(venta.getModo_Pago());
		ventaExistente.setValor_Venta(venta.getValor_Venta());
		ventaServicio.updateVenta(ventaExistente);
		return "redirect:/index";
	}
	
	@GetMapping("/ConsultarV/{ID_Venta}")
	public String deleteCliente(@PathVariable Long ID_Venta) {
		
		ventaServicio.delete(ID_Venta);
		return "redirect:/Solware2/home/ConsultarV";
		
	}


}
