package com.app.web.servicio;

import java.util.List;


import com.app.web.entidad.Producto;


public interface ProductoServicio {
	
	public List<Producto> listarProducto();
    public Producto obtenerProductoPorId(Long ID_Producto);
    public Producto guardarProducto(Producto producto );
    public Producto updateProducto(Producto producto );
    public void delete(Long ID_Producto );

}
