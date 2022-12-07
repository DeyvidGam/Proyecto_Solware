package com.app.web.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Producto;
import com.app.web.repositorio.ProductoRepositorio;
@Service

public class ProductoServicioImp implements ProductoServicio {
	@Autowired
    private ProductoRepositorio productoRepositorio;


	@Override
	public List<Producto> listarProducto() {
		return productoRepositorio.findAll();
	}

	@Override
	public Producto obtenerProductoPorId(Long ID_Producto) {
		return productoRepositorio.findById(ID_Producto).get();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		
		return productoRepositorio.save(producto);
	}

	@Override
	public Producto updateProducto(Producto producto) {
		return productoRepositorio.save(producto);
	}

	@Override
	public void delete(Long ID_Producto) {
		productoRepositorio.deleteById(ID_Producto);
		
	}
   
	
	

}
