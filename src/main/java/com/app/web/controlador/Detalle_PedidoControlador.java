package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Detalle_Pedido;
import com.app.web.servicio.Detalle_PedidoServicio;

@Controller
public class Detalle_PedidoControlador {

	@Autowired
	private Detalle_PedidoServicio detalle_PedidoServicio;

	@GetMapping("/detalle_Pedido")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Detalle_Pedido", detalle_PedidoServicio.listarDetalle_Pedido());
		return "detalle_Pedido";
	}

	@GetMapping("/detalle_Pedido/nuevo")
	public String crearCliente(Model modelo) {
		Detalle_Pedido detalle_Pedido = new Detalle_Pedido();
		modelo.addAttribute("Detalle_Pedido", detalle_Pedido);
		return "creardetalle_Pedido";

	}

	@PostMapping("/detalle_Pedido")
	public String guardarCliente(@ModelAttribute("Detalle_Pedido") Detalle_Pedido detalle_Pedido) {
		detalle_PedidoServicio.guardarDetalle_Pedido(detalle_Pedido);
		return "redirect:/detalle_Pedido";
	}

	@GetMapping("/detalle_Pedido/editar/{ID_Detalle_Pedido}")
	public String Editar(@PathVariable Long ID_Detalle_Pedido, Model modelo) {
		modelo.addAttribute("Cliente", detalle_PedidoServicio.obtenerDetalle_PedidoPorId(ID_Detalle_Pedido));
		return "editar_detalle_Pedido";
	}

	@PostMapping("/index/{ID_Detalle_Pedido}")
	public String updateCliente(@PathVariable Long ID_Detalle_Pedido,
			@ModelAttribute("Detalle_Pedido") Detalle_Pedido detalle_Pedido, Model modelo) {
		Detalle_Pedido detalle_PedidoExistente = detalle_PedidoServicio.obtenerDetalle_PedidoPorId(ID_Detalle_Pedido);
		detalle_PedidoExistente.setID_Detalle_Pedido(ID_Detalle_Pedido);
		detalle_PedidoExistente.setCantidad(detalle_Pedido.getCantidad());
		detalle_PedidoExistente.setSubTotal(detalle_Pedido.getSubTotal());
		detalle_PedidoExistente.setPedido(detalle_Pedido.getPedido());
		detalle_PedidoExistente.setProducto(detalle_Pedido.getProducto());
		detalle_PedidoServicio.updateDetalle_Pedido(detalle_PedidoExistente);
		return "redirect:/index";
	}

	@GetMapping("/detalle_Pedido/{ID_Detalle_Pedido}")
	public String deleteCliente(@PathVariable Long ID_Detalle_Pedido) {
		detalle_PedidoServicio.delete(ID_Detalle_Pedido);
		return "redirect:/detalle_Pedido";

	}

}
