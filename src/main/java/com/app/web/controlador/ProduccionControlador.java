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

import com.app.web.entidad.Inventario;
import com.app.web.entidad.Pedido;
import com.app.web.entidad.Produccion;
import com.app.web.entidad.Usuario;
import com.app.web.servicio.InventarioServicio;
import com.app.web.servicio.PedidoServicio;
import com.app.web.servicio.ProduccionServicio;
import com.app.web.servicio.UsuarioServicio;

@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ProduccionControlador {
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired
	private ProduccionServicio produccionServicio;
	@Autowired
	private PedidoServicio pedidoServicio; 
	@Autowired
	private InventarioServicio inventarioServicio; 
	
	@GetMapping("/InicioP")
	public String InicioP(Model modelo) {
		return "InicioP";
	}
	@GetMapping("/ConsultarPAdmin")

	public String listarproduccion(Model modelo) {
		modelo.addAttribute("Produccion", produccionServicio.listarproduccion());
		return "ConsultarPAdmin";
	}
	
	@GetMapping("/ProducionAdmin")
	public String crearProduccion(Model modelo) {
		Produccion produccion = new Produccion();
		List<Usuario> listausuario = usuarioServicio.listarusuario();
		List<Pedido> listapedido = pedidoServicio.listarpedidos();
		List<Inventario> listainventario = inventarioServicio.listarinventario();
		modelo.addAttribute("Produccion", produccion);
		modelo.addAttribute("Usuarios", listausuario);
		modelo.addAttribute("Pedidos", listapedido);
		modelo.addAttribute("Inventarios", listainventario);
		return "ProducionAdmin";
	}
	
	@PostMapping("/ConsultarPAdmin")
	public String guardarProduccion(@ModelAttribute("Produccion") Produccion produccion) {
		produccionServicio.guardarProduccion(produccion);
		return "redirect:/Solware2/home/ConsultarPAdmin";
	}
	@GetMapping("/ConsultarPAdmin/editar/{ID_Produccion}")
	public String Editar(@PathVariable Long ID_Produccion,Model modelo ) {
		modelo.addAttribute("Produccion", produccionServicio.obtenerProduccionPorId(ID_Produccion));
		List<Usuario> listausuario = usuarioServicio.listarusuario();
		List<Pedido> listapedido = pedidoServicio.listarpedidos();
		List<Inventario> listainventario = inventarioServicio.listarinventario();
		modelo.addAttribute("Usuarios", listausuario);
		modelo.addAttribute("Pedidos", listapedido);
		modelo.addAttribute("Inventarios", listainventario);
	    return "editar_Produccion";
	}
	
	@PostMapping("/ConsultarPAdmin/{ID_Produccion}")
	public String updateProduccion(@PathVariable Long ID_Produccion, @ModelAttribute("Produccion") Produccion produccion, Model modelo) {
		Produccion produccionExistente = produccionServicio.obtenerProduccionPorId(ID_Produccion);
		produccionExistente.setID_Produccion(ID_Produccion);
		produccionExistente.setOperario(produccion.getOperario());
		produccionExistente.setEstado_Produccion(produccion.getEstado_Produccion());
		produccionExistente.setFecha_Inicio(produccion.getFecha_Inicio());
		produccionExistente.setCantidad(produccion.getCantidad());
		produccionExistente.setFecha_Fin(produccion.getFecha_Fin());
		produccionExistente.setPedido(produccion.getPedido());
		
		produccionServicio.updateProduccion(produccionExistente);
		return "redirect:/Solware2/home/ConsultarPAdmin";
	}
	
	@GetMapping("/ConsultarPAdmin/{ID_Produccion}")
	public String deleteProduccion(@PathVariable Long ID_Produccion) {
		
		produccionServicio.delete(ID_Produccion);
		return "redirect:/Solware2/home/ConsultarPAdmin";
		
	}
	
}
