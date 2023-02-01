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

import com.app.web.entidad.Pedido;
import com.app.web.entidad.Venta;
import com.app.web.servicio.PedidoServicio;
import com.app.web.servicio.VentaServicio;



@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class VentaControlador {
	
	@Autowired
	private PedidoServicio pedidoServicio;
	@Autowired
	private VentaServicio ventaServicio;

	@GetMapping("/ConsultarAdmin")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Venta", ventaServicio.listarventas());
		return "ConsultarAdmin";
	}

	@GetMapping("/ventasAdmin")
	public String crearCliente(Model modelo) {
		Venta venta = new Venta();
		List<Pedido> listapedido = pedidoServicio.listarpedidos(); 
		modelo.addAttribute("Venta", venta);
		modelo.addAttribute("Pedidos", listapedido);
		return "ventasAdmin";

	}

	@PostMapping("/ConsultarAdmin")
	public String guardarCliente(@ModelAttribute("Venta") Venta venta) {
		ventaServicio.guardarVenta(venta);
		return "redirect:/Solware2/home/ConsultarAdmin";
	}

	@GetMapping("/ConsultarAdmin/editar/{ID_Venta}")
	public String Editar(@PathVariable Long ID_Venta,Model modelo ) {
		modelo.addAttribute("Venta", ventaServicio.obtenerVentaPorId(ID_Venta));
		List<Pedido> listapedido = pedidoServicio.listarpedidos(); 
		modelo.addAttribute("Pedidos", listapedido);
	    return "editar_venta";
	}

	@PostMapping("/ConsultarAdmin/{ID_Venta}")
	public String updateVenta(@PathVariable Long ID_Venta, @ModelAttribute("Venta") Venta venta, Model modelo) {
		Venta ventaExistente = ventaServicio.obtenerVentaPorId(ID_Venta);
		ventaExistente.setID_Venta(ID_Venta);
		ventaExistente.setFechaYHora(venta.getFechaYHora());
		ventaExistente.setModo_Pago(venta.getModo_Pago());
		ventaExistente.setValor_Venta(venta.getValor_Venta());
		ventaServicio.updateVenta(ventaExistente);
		return "redirect:/Solware2/home/ConsultarAdmin";
	}
	
	@GetMapping("/ConsultarAdmin/{ID_Venta}")
	public String deleteCliente(@PathVariable Long ID_Venta) {
		
		ventaServicio.delete(ID_Venta);
		return "redirect:/Solware2/home/ConsultarAdmin";
		
	}


}
