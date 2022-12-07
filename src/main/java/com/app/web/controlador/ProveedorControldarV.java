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

import com.app.web.entidad.Proveedor;
import com.app.web.servicio.ProveedorServicio;
@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ProveedorControldarV {
	
	@Autowired
	private ProveedorServicio proveedorServicio;
	
	@GetMapping("/C_Proveedores")
	public String listarproveedores(Model modelo) {
		modelo.addAttribute("Proveedor", proveedorServicio.listarproveedores());
		return "C_Proveedores";
	}
	
	

	@GetMapping("/C_Proveedores/nuevo")
	public String crearCliente(Model modelo) {
		Proveedor proveedor = new Proveedor();
		modelo.addAttribute("Proveedor", proveedor);
		return "Proveedores";

	}

	@PostMapping("/C_Proveedores")
	public String guardarCliente(@ModelAttribute("Proveedor") Proveedor proveedor) {
		proveedorServicio.guardarProveedor(proveedor);
		return "redirect:/Solware2/home/C_Proveedores";
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
		proveedorExistente.setTipoProducto(proveedor.getTipoProducto());
		proveedorExistente.setProducto(proveedor.getProducto());
		proveedorServicio.updateProveedor(proveedorExistente);
		return "redirect:/proveedor";
	}
	
	@GetMapping("/C_Proveedores/{ID_Proveedor}")
	public String deleteProveedor(@PathVariable Long ID_Proveedor) {
		
		proveedorServicio.delete(ID_Proveedor);
		return "redirect:/Solware2/home/C_Proveedores";
		
	}

}
