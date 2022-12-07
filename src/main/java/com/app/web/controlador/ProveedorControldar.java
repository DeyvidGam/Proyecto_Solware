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

import com.app.web.entidad.Producto;
import com.app.web.entidad.Proveedor;
import com.app.web.servicio.ProductoServicio;
import com.app.web.servicio.ProveedorServicio;
@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ProveedorControldar {
	
	@Autowired
	
	private ProveedorServicio proveedorServicio;
	@Autowired
	
	private ProductoServicio productoServicio;
	
	
	@GetMapping("/C_ProveedoresA")
	public String listarproveedor(Model modelo) {
		modelo.addAttribute("Proveedor", proveedorServicio.listarproveedores());
		return "C_ProveedoresA";
	}
	
	@GetMapping("/ProveedoresA")
	public String crearProveedor(Model modelo) {
		Proveedor proveedor = new Proveedor();
		List<Producto> listaproducto = productoServicio.listarProducto();
		modelo.addAttribute("Proveedor", proveedor);
		modelo.addAttribute("Productos", listaproducto);
		return "ProveedoresA";

	}
	@PostMapping("/C_ProveedoresA")
	public String guardarProveedor(@ModelAttribute("Proveedor") Proveedor proveedor) {
		proveedorServicio.guardarProveedor(proveedor);
		return "redirect:/Solware2/home/C_ProveedoresA";
	}
	@PostMapping("/proveedor")
	public String guardarCliente(@ModelAttribute("Proveedor") Proveedor proveedor) {
		proveedorServicio.guardarProveedor(proveedor);
		return "redirect:/Solware2/home/C_ProveedoresA";
	}

	@GetMapping("/C_ProveedoresA/editar/{ID_Proveedor}")
	public String Editar(@PathVariable Long ID_Proveedor,Model modelo ) {
		modelo.addAttribute("Proveedor", proveedorServicio.obtenerProveedorPorId(ID_Proveedor));
	    return "editar_proveedor";
	}

	@PostMapping("/C_ProveedoresA/{ID_Proveedor}")
	public String updateProveedor(@PathVariable Long ID_Proveedor, @ModelAttribute("Proveedor") Proveedor proveedor, Model modelo) {
		Proveedor proveedorExistente = proveedorServicio.obtenerProveedorPorId(ID_Proveedor);
		proveedorExistente.setID_Proveedor(ID_Proveedor);
		proveedorExistente.setNombre(proveedor.getNombre());
		proveedorExistente.setEmail(proveedor.getEmail());
		proveedorExistente.setTelefono(proveedor.getTelefono());
		proveedorExistente.setTipoProducto(proveedor.getTipoProducto());
		proveedorExistente.setProducto(proveedor.getProducto());
		proveedorServicio.updateProveedor(proveedorExistente);
		return "redirect:/Solware2/home/C_ProveedoresA";
	}
	
	@GetMapping("/C_ProveedoresA/{ID_Proveedor}")
	public String deleteProveedor(@PathVariable Long ID_Proveedor) {
		
		proveedorServicio.delete(ID_Proveedor);
		return "redirect:/Solware2/home/C_ProveedoresA";
		
	}

}
