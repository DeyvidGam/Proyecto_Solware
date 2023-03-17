package com.app.web.controlador;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.web.entidad.Pedido;
import com.app.web.entidad.Venta;
import com.app.web.repositorio.PedidoRepositorio;
import com.app.web.repositorio.VentaRepositorio;
import com.app.web.servicio.PedidoServicio;
import com.app.web.servicio.VentaServicio;



@Controller
@RequestMapping(path="/Solware2/Vendedor")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class VentaControladorV {


	@Autowired
	private PedidoServicio pedidoServicio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	private List<Pedido> listaDetalles= new ArrayList<Pedido>();
	@Autowired
	private VentaServicio ventaServicio;
	private VentaRepositorio ventaRepositorio;

	@GetMapping("/ConsultarV")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Venta", ventaServicio.listarventas());
		return "ConsultarV";
	}

	@GetMapping("/ConsultarV/nuevo")
	public String crearCliente(Model modelo) {
		List<Pedido> pedidos = (List<Pedido>) pedidoServicio.listarpedidos();
		modelo.addAttribute("pedidos", pedidos);
		return "ventas";

	}
	@PostMapping("/ventas")
	public String registerVenta(@RequestParam("idPedido") Long idPedido,
			@RequestParam("Modo_Pago") String Modo_Pago,
			Model modelo, RedirectAttributes attributes) {
		// Retrieve the corresponding Pedido object from the database
		List<Pedido> listapedido = pedidoServicio.listarpedidos(); 
		Pedido pedido = pedidoServicio.obtenerPedidoPorId(idPedido);

		List<Venta> ventas = ventaServicio.listarventas();


		for (Venta venta : ventas) {


			if (venta.getiDPedido() != null && venta.getiDPedido().getID_Pedido() == pedido.getID_Pedido()) {


				// If a Venta object with the same Pedido already exists, set an error message and redirect back to the ventasAdmin page.

				attributes.addFlashAttribute("mensaje", "El pedido ya fue vendio");
				return "redirect:/Solware2/ConsultarV/nuevo";
			}
		}
		Venta venta = new Venta();
		venta.setFechaYHora(LocalDateTime.now());
		venta.setModo_Pago(Modo_Pago);
		venta.setValor_Venta(pedido.getTotal());
		venta.setiDPedido(pedido);

		// Save the new Venta object to the database
		ventaServicio.guardarVenta(venta);
		attributes.addFlashAttribute("exitoso", " Registro Exitoso");
		return "redirect:/Solware2/ConsultarV/nuevo";
	}
	@PostMapping("/ConsultarV")
	public String guardarCliente(@ModelAttribute("Venta") Venta venta) {
		ventaServicio.guardarVenta(venta);
		return "redirect:/Solware2/ConsultarV";
	}



}
