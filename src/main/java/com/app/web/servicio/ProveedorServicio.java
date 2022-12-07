package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Proveedor;



public interface ProveedorServicio {
	
	
	public List<Proveedor> listarproveedores();
    public Proveedor  obtenerProveedorPorId(Long ID_Proveedor);
    public Proveedor guardarProveedor(Proveedor proveedor);
    public  Proveedor updateProveedor(Proveedor proveedor);
    public void delete(Long ID_Proveedor);

}
