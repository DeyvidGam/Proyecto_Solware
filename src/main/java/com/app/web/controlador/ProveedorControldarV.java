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
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ProveedorControldarV {
	
	@Autowired
	private ProveedorServicio proveedorServicio;
	@Autowired
	private ProductoServicio productoServicio;
	
	
	@GetMapping("/C_Proveedores")
	public String listarproveedor(Model modelo) {
		modelo.addAttribute("Proveedor", proveedorServicio.listarproveedores());
		return "C_Proveedores";
	}
	
	

	@GetMapping("/C_Proveedores/nuevo")
	public String crearProveedor(Model modelo) {
		Proveedor proveedor = new Proveedor();
		List<Producto> listaproducto = productoServicio.listarProducto();
		modelo.addAttribute("Proveedor", proveedor);
		modelo.addAttribute("Productos", listaproducto);
		return "Proveedores";

	}

	@PostMapping("/C_Proveedores")
	public String guardarCliente(@ModelAttribute("Proveedor") Proveedor proveedor) {
		proveedorServicio.guardarProveedor(proveedor);
		return "redirect:/Solware2/C_Proveedores";
	}

	@GetMapping("/C_Proveedores/editar/{ID_Proveedor}")
	public String Editar(@PathVariable Long ID_Proveedor,Model modelo ) {
		modelo.addAttribute("Proveedor", proveedorServicio.obtenerProveedorPorId(ID_Proveedor));
	    return "editar_proveedor";
	}

	@PostMapping("/C_Proveedores/{ID_Proveedor}")
	public String updateProveedor(@PathVariable Long ID_Proveedor, @ModelAttribute("Proveedor") Proveedor proveedor, Model modelo) {
		Proveedor proveedorExistente = proveedorServicio.obtenerProveedorPorId(ID_Proveedor);
		proveedorExistente.setID_Proveedor(ID_Proveedor);
		proveedorExistente.setNombre(proveedor.getNombre());
		proveedorExistente.setEmail(proveedor.getEmail());
		proveedorExistente.setTelefono(proveedor.getTelefono());
		
		proveedorServicio.updateProveedor(proveedorExistente);
		return "redirect:/proveedor";
	}
	
	@GetMapping("/C_Proveedores/{ID_Proveedor}")
	public String deleteProveedor(@PathVariable Long ID_Proveedor) {
		
		proveedorServicio.delete(ID_Proveedor);
		return "redirect:/Solware2/C_Proveedores";
		
	}

}
