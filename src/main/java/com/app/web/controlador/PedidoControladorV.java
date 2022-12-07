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

import com.app.web.entidad.Pedido;
import com.app.web.servicio.PedidoServicio;




@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class PedidoControladorV {
	
	@Autowired
	private PedidoServicio pedidoServicio;

	@GetMapping("/C_Pedidos")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Pedido", pedidoServicio.listarpedidos());
		return "C_Pedidos";
	}

	@GetMapping("/Pedido/nuevo")
	public String crearPedido(Model modelo) {
		Pedido pedido = new Pedido();
		modelo.addAttribute("Pedido", pedido);
		return "crearPedido";

	}

	@PostMapping("/Pedido")
	public String guardarCliente(@ModelAttribute("Pedido") Pedido pedido) {
		pedidoServicio.guardarPedido(pedido);
		return "redirect:/Pedido";
	}

	@GetMapping("/C_Pedidos/editar/{ID_Pedido}")
	public String Editar(@PathVariable Long ID_Pedido,Model modelo ) {
		modelo.addAttribute("Pedido", pedidoServicio.obtenerPedidoPorId(ID_Pedido));
	    return "editar_pedido";
	}

	@PostMapping("/Pedido/{ID_Pedido}")
	public String updateCliente(@PathVariable Long ID_Pedido, @ModelAttribute("Pedido") Pedido pedido, Model modelo) {
		Pedido pedidoExistente = pedidoServicio.obtenerPedidoPorId(ID_Pedido);
		pedidoExistente.setID_Pedido(ID_Pedido);
		pedidoExistente.setFecha_Pedido(pedido.getFecha_Pedido());
		pedidoExistente.setTotal(pedido.getTotal());
		pedidoServicio.updatePedido(pedidoExistente);
		return "redirect:/Pedido";
	}
	
	@GetMapping("/C_Pedidos/{ID_Pedido}")
	public String deleteCliente(@PathVariable Long ID_Pedido) {
		
		pedidoServicio.delete(ID_Pedido);
		return "redirect:/Solware2/home/C_Pedidos";
		
	}


}
