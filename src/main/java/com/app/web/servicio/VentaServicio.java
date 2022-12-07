package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Venta;



public interface VentaServicio {

	
	public List<Venta> listarventas();
    public Venta  obtenerVentaPorId(Long ID_Venta);
    public Venta guardarVenta(Venta venta);
    public  Venta updateVenta(Venta venta);
    public void delete(Long ID_Venta);
}
