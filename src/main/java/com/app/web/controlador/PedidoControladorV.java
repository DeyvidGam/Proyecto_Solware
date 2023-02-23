package com.app.web.controlador;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
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

import org.slf4j.*;
import com.app.web.entidad.Cliente;
import com.app.web.entidad.Detalle_Pedido;
import com.app.web.entidad.Pedido;
import com.app.web.entidad.Producto;
import com.app.web.entidad.Proveedor;
import com.app.web.entidad.Venta;
import com.app.web.servicio.ClienteServicio;
import com.app.web.servicio.ClienteServicioImp;
import com.app.web.servicio.Detalle_PedidoServicioImp;
import com.app.web.servicio.PedidoServicio;
import com.app.web.servicio.ProductoServicio;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;



@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class PedidoControladorV {
private final Logger log = LoggerFactory.getLogger(PedidoControlador.class);
	
	@Autowired
	
	private ClienteServicioImp clienteServicioImp;
	private List<Cliente> listarClientes;
	
	
	@Autowired
	private Detalle_PedidoServicioImp detalle_PedidoServicio;
	private List<Detalle_Pedido> listaDetalles= new ArrayList<Detalle_Pedido>();
	private List<Detalle_Pedido> listaDetallesEditar= new ArrayList<Detalle_Pedido>();
	
	Pedido pedido = new Pedido();
	Venta venta = new Venta();
	@Autowired
	private PedidoServicio pedidoServicio;
	
	@Autowired
	private ClienteServicio clienteServicio;
	@Autowired
	private ProductoServicio  productoServicio;

	@GetMapping("/Pedidos")
	public String Pedidos(Model modelo) {


		modelo.addAttribute("Pedido", pedido);
		modelo.addAttribute("Producto", productoServicio.listarProducto());
		modelo.addAttribute("Deatalle", detalle_PedidoServicio.listarDetalle_Pedido());
		this.listarClientes = this.clienteServicioImp.listarclientes();
		modelo.addAttribute("Clientes", this.listarClientes);


		return "Pedidos";
	}
	@GetMapping("/C_Pedidos")

	public String listarclientes(Model modelo) {
		modelo.addAttribute("Pedido", pedidoServicio.listarpedidos());
		return "C_Pedidos";
	}
	@GetMapping("/PedidosV")
	public String crearPedido(Model modelo) {
		
		modelo.addAttribute("Pedido", pedido);
		modelo.addAttribute("Producto", productoServicio.listarProducto());
		modelo.addAttribute("Deatalle", detalle_PedidoServicio.listarDetalle_Pedido());
		this.listarClientes = this.clienteServicioImp.listarclientes();
		modelo.addAttribute("Clientes", this.listarClientes);
		return "Pedidos";

	}

	@GetMapping("/agregarProducto")
	public String CPedido(Model modelo) {
		
		modelo.addAttribute("Pedido", pedido);
		modelo.addAttribute("Producto", productoServicio.listarProducto());
		this.listarClientes = this.clienteServicioImp.listarclientes();
		modelo.addAttribute("Clientes", this.listarClientes);
		modelo.addAttribute("Deatalle", detalle_PedidoServicio.listarDetalle_Pedido());
		return "agregarPedidoV";

	}
	@GetMapping("/PedidosV/{id}")
	public String pedidoNuevo(@PathVariable("id") Long id,Model modelo) {
		
	Producto producto= this.productoServicio.obtenerProductoPorId(id);
		modelo.addAttribute("producto",producto);
		
		return "verPedidoProductoV";
		
	}
	@PostMapping("/detalle")
	public String agregarDetalle(@RequestParam Long id, @RequestParam Integer cantidad, Model modelo ) {
		Detalle_Pedido detalle = new Detalle_Pedido();
		Producto producto =new Producto();
		double sumaTotal = 0;
		Producto productoOptional = this.productoServicio.obtenerProductoPorId(id);
		
		producto = productoOptional;
		detalle.setCantidad(cantidad);
		detalle.setSubTotal(producto.getPrecio()*cantidad);
		detalle.setProducto(producto);
		
		Long idProducto = producto.getID_Producto();
		boolean insertado = listaDetalles.stream().anyMatch(m->m.getProducto().getID_Producto() ==idProducto);
		
		if (!insertado) {
			listaDetalles.add(detalle);
		}
		
		this.listarClientes= this.clienteServicio.listarclientes();
		
		modelo.addAttribute("Pedido", pedido);
		
		modelo.addAttribute("listarClientes",this.listarClientes);
		modelo.addAttribute("listaDetalles",this.listaDetalles);
		modelo.addAttribute("venta",venta);
		List<Cliente> listarCliente = clienteServicio.listarclientes();
		modelo.addAttribute("Clientes", listarCliente);
		
		return "Pedidos";
		
	}
	
	@GetMapping("/eliminaDetalle/{id}")
    public String eliminarDetalle(@PathVariable Long id, Model modelo ) {
	List<Detalle_Pedido> listanuevoDetalle= new ArrayList<Detalle_Pedido>();
	
	for (Detalle_Pedido detalle_Pedido : listaDetalles) {
		if (detalle_Pedido.getProducto().getID_Producto()!= id) {
			listanuevoDetalle.add(detalle_Pedido);
		}
		
	}
	listaDetalles= listanuevoDetalle;
		log.info("@@@ detalle id:{}",id );
		
		modelo.addAttribute("listaDetalles",this.listaDetalles);
		
		modelo.addAttribute("listarClientes",this.listarClientes);
		modelo.addAttribute("Pedido", pedido);
		modelo.addAttribute("venta",venta);
		List<Cliente> listarCliente = clienteServicio.listarclientes();
		modelo.addAttribute("Clientes", listarCliente);
		return "Pedidos";
	}
	
	@PostMapping("/GuardarPedido")

	public String  GuardarPedido(@ModelAttribute("Pedido") Pedido pedido,RedirectAttributes attributes,Model modelo) {
		if (listaDetalles.isEmpty()) {
	        attributes.addFlashAttribute("mensaje", " No se puede guardar un pedido sin detalles");
	        
	        return "redirect:/Solware2/Pedidos";
	    }


		Date fechacreacion= new Date();
		pedido.setFecha_Pedido(fechacreacion);
		int sumaTotal =0;
		sumaTotal =(int) listaDetalles.stream().mapToDouble(dt->dt.getSubTotal()).sum();
		pedido.setTotal(sumaTotal);
		for (Detalle_Pedido detalle_Pedido : listaDetalles) {
			detalle_Pedido.setPedido(pedido);
			this.detalle_PedidoServicio.guardarDetalle_Pedido(detalle_Pedido);	
		}
		pedido = new Pedido();
		listaDetalles.clear();
		attributes.addFlashAttribute("exitoso", " Registro Exitoso");
		return "redirect:/Solware2/Pedidos";
	}
	@PostMapping("/Solware2/C_Pedidos")
	public String guardarCliente(@ModelAttribute("Pedido") Pedido pedido) {
		pedidoServicio.guardarPedido(pedido);
		return "redirect:/Solware2/C_Pedidos";
	}

	@GetMapping("/C_Pedidos/editar/{ID_Pedido}")
	public String Editar(@PathVariable Long ID_Pedido,Model modelo ) {
		modelo.addAttribute("Pedido", pedidoServicio.obtenerPedidoPorId(ID_Pedido));
	    return "editar_pedido";
	}

	@PostMapping("/C_Pedidos/{ID_Pedido}")
	public String updateCliente(@PathVariable Long ID_Pedido, @ModelAttribute("Pedido") Pedido pedido, Model modelo) {
		Pedido pedidoExistente = pedidoServicio.obtenerPedidoPorId(ID_Pedido);
		pedidoExistente.setID_Pedido(ID_Pedido);
		pedidoExistente.setFecha_Pedido(pedido.getFecha_Pedido());
		pedidoExistente.setTotal(pedido.getTotal());
		pedidoServicio.updatePedido(pedidoExistente);
		return "redirect:/Solware2/C_Pedidos" ;
	}
	
	@GetMapping("/C_Pedidos/{ID_Pedido}")
	public String deleteCliente(@PathVariable Long ID_Pedido) {
		
		pedidoServicio.delete(ID_Pedido);
		return "redirect:/Solware2/C_Pedidos";
		
	}


}
