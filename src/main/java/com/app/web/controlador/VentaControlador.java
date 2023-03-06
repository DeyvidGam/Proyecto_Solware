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
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class VentaControlador {

	@Autowired
	private PedidoServicio pedidoServicio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	private List<Pedido> listaDetalles= new ArrayList<Pedido>();
	@Autowired
	private VentaServicio ventaServicio;
	private VentaRepositorio ventaRepositorio;
	@GetMapping("/ConsultarAdmin")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Venta", ventaServicio.listarventas());
		return "ConsultarAdmin";
	}

	@GetMapping("/ventasAdmin")
	public String crearCliente(Model modelo) {
		List<Pedido> pedidos = (List<Pedido>) pedidoServicio.listarpedidos();
		modelo.addAttribute("pedidos", pedidos);
		return "ventasAdmin";
	}

	@PostMapping("/ventas")
	public String registerVenta(@RequestParam("idPedido") Long idPedido,
	                            @RequestParam("Modo_Pago") String Modo_Pago,
	                            Model modelo, RedirectAttributes attributes) {
		// Recuperar el objeto Pedido correspondiente de la base de datos
	    Pedido pedido = pedidoServicio.obtenerPedidoPorId(idPedido);

	    List<Venta> ventas = ventaServicio.listarventas();

	    boolean ventaExistenteActiva = false;

	    for (Venta venta : ventas) {
	        if (venta.getiDPedido() != null && venta.getiDPedido().getID_Pedido() == pedido.getID_Pedido() && venta.isEstado()) {
	        	// Si ya existe un objeto Venta con el mismo Pedido y estado "activo",
	            // establece la bandera en true
	            ventaExistenteActiva = true;
	            break;
	        }
	    }

	 // Si existe un objeto Venta con el mismo estado Pedido y "activo", establece un mensaje de error y redirige de nuevo a la página ventasAdmin.
	    if (ventaExistenteActiva) {
	        attributes.addFlashAttribute("mensaje", "El pedido ya fue vendido");
	        return "redirect:/Solware2/home/ventasAdmin";
	    } else {
	    	// Crear un nuevo objeto Venta y guardarlo en la base de datos
	        Venta venta = new Venta();
	        venta.setFechaYHora(LocalDateTime.now());
	        venta.setModo_Pago(Modo_Pago);
	        venta.setValor_Venta(pedido.getTotal());
	        venta.setEstado(true);
	        venta.setiDPedido(pedido);
	        ventaServicio.guardarVenta(venta);

	        attributes.addFlashAttribute("exitoso", "Registro Exitoso");
	        return "redirect:/Solware2/home/ventasAdmin";
	    }
	}

	@PostMapping("/ConsultarAdmin")
	public String guardarCliente(@ModelAttribute("Venta") Venta venta, RedirectAttributes attributes) {

		ventaServicio.guardarVenta(venta);
		return "redirect:/Solware2/home/ventasAdmin";
	}

	@PostMapping("/ventas/estado")
	public String cambiarEstadoVenta(@RequestParam("idVenta") Long idVenta, Model modelo, RedirectAttributes attributes) {
	    Venta venta = ventaServicio.obtenerVentaPorId(idVenta);
	    
	    if (!venta.isEstado()) {
	    	attributes.addFlashAttribute("mensaje", "No se puede volver a cambiar el estado, tiene que crear una nueva venta ");
	        return "redirect:/Solware2/home/ConsultarAdmin"; // Si la venta ya está inactiva, redirige a la página de lista de ventas
	    }
	    
	    venta.setEstado(false); // Cambia el estado actual de la venta a inactivo
	    ventaServicio.guardarVenta(venta); // Actualiza la venta en la base de datos
	    return "redirect:/Solware2/home/ConsultarAdmin"; // Redirige a la página de lista de ventas
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
		Long idPedido = venta.getID_Venta();
		List<Pedido> pedidos = pedidoServicio.listarpedidos();
		    int cantidadTotal = 0;
		    for (Pedido pedido : pedidos) {
		    	if (pedido.getID_Pedido().equals(idPedido)  ) 
			    {
		    		cantidadTotal += pedido.getTotal();
			    }
		        
		    }
		   
		Venta ventaExistente = ventaServicio.obtenerVentaPorId(ID_Venta);
		Pedido pedido = pedidoServicio.obtenerPedidoPorId(ID_Venta);
		ventaExistente.setFechaYHora(LocalDateTime.now());
		ventaExistente.setModo_Pago(venta.getModo_Pago());
		ventaExistente.setValor_Venta(cantidadTotal);
		ventaExistente.setiDPedido(venta.getiDPedido());
		ventaServicio.updateVenta(ventaExistente);
		return "redirect:/Solware2/home/ConsultarAdmin";
	}

	@GetMapping("/ConsultarAdmin/{ID_Venta}")
	public String deleteCliente(@PathVariable Long ID_Venta) {

		ventaServicio.delete(ID_Venta);
		return "redirect:/Solware2/home/ConsultarAdmin";

	}


}
