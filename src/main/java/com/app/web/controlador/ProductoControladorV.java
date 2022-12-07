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

import com.app.web.entidad.Producto;
import com.app.web.servicio.ProductoServicio;

@Controller
@RequestMapping(path="/Solware2")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ProductoControladorV {

	@Autowired
	private ProductoServicio  productoServicio;
	
	@GetMapping("/C_Productos")
	public String listarProducto(Model modelo) {
		modelo.addAttribute("Producto", productoServicio.listarProducto());
	  return "C_Productos";
	}
	
	@GetMapping("/C_Productos/nuevo")
	public String crearProducto(Model modelo) {
		Producto producto = new Producto();
		modelo.addAttribute("Producto", producto);
		return "Productos";
	}
	
	@PostMapping("/C_Productos")
	public String guardarProducto(@ModelAttribute("Producto") Producto producto) {
		productoServicio.guardarProducto(producto);
		return "redirect:/Solware2/home/C_Productos";
	}
	
	@GetMapping("/producto/editar/{ID_Producto}")
	public String Editar(@PathVariable Long ID_Producto,Model modelo ) {
		modelo.addAttribute("Producto", productoServicio.obtenerProductoPorId(ID_Producto));
	    return "editar_producto";
	}
	
	@PostMapping("/producto/{ID_Producto}")
	public String updateProducto(@PathVariable Long ID_Producto, @ModelAttribute("Producto") Producto producto, Model modelo) {
		Producto productoExistente = productoServicio.obtenerProductoPorId(ID_Producto);
		productoExistente.setID_Producto(ID_Producto);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setProveedor(producto.getProveedor());
		productoExistente.setTamano(producto.getTamano());
		productoExistente.setPrecio(producto.getPrecio());
		
		productoServicio.updateProducto(productoExistente);
		return "redirect:/producto";
	}
	
	@GetMapping("/C_Productos/{ID_Producto}")
	public String deleteCliente(@PathVariable Long ID_Producto) {
		
		productoServicio.delete(ID_Producto);
		return "redirect:/Solware2/home/C_Productos";
		
	}
	
}
