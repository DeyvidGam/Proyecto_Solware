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
public class ProductoControlador {

	@Autowired
	private ProductoServicio  productoServicio;
	@Autowired
	private ProveedorServicio proveedorServicio;
	@GetMapping("/C_ProductosA")
	public String listarProducto(Model modelo) {
		modelo.addAttribute("Producto", productoServicio.listarProducto());
	  return "C_ProductosA";
	}
	
	@GetMapping("/ProductosA")
	public String crearProducto(Model modelo) {
		Producto producto = new Producto();
		List<Proveedor> listaproveedor = proveedorServicio.listarproveedores();
		modelo.addAttribute("Producto", producto);
		modelo.addAttribute("Proveedores", listaproveedor);
		return "ProductosA";
	}
	
	@PostMapping("/C_ProductosA")
	public String guardarProducto(@ModelAttribute("Producto") Producto producto) {
		productoServicio.guardarProducto(producto);
		return "redirect:/Solware2/home/C_ProductosA";
	}
	
	@GetMapping("/C_ProductosA/editar/{ID_Producto}")
	public String Editar(@PathVariable Long ID_Producto,Model modelo ) {
		modelo.addAttribute("Producto", productoServicio.obtenerProductoPorId(ID_Producto));
	    return "editar_producto";
	}
	
	@PostMapping("/C_ProductosA/{ID_Producto}")
	public String updateProducto(@PathVariable Long ID_Producto, @ModelAttribute("Producto") Producto producto, Model modelo) {
		Producto productoExistente = productoServicio.obtenerProductoPorId(ID_Producto);
		productoExistente.setID_Producto(ID_Producto);
		productoExistente.setNombre(producto.getNombre());
		productoExistente.setProveedor(producto.getProveedor());
		productoExistente.setTamano(producto.getTamano());
		productoExistente.setPrecio(producto.getPrecio());
		
		productoServicio.updateProducto(productoExistente);
		return "redirect:/Solware2/home/C_ProductosA";
	}
	
	@GetMapping("/C_ProductosA/{ID_Producto}")
	public String deleteProducto(@PathVariable Long ID_Producto) {
		
		productoServicio.delete(ID_Producto);
		return "redirect:/Solware2/home/C_ProductosA";
		
	}
	
}
