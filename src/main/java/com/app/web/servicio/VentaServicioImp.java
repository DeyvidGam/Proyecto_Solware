package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.web.entidad.Venta;
import com.app.web.repositorio.ClienteRepositorio;
import com.app.web.repositorio.VentaRepositorio;
@Service
public class VentaServicioImp implements VentaServicio{

	
	@Autowired
    private VentaRepositorio ventaRepositorio;

    private Venta venta;
	
	@Override
	public List<Venta> listarventas() {
		
		return ventaRepositorio.findAll();
	}

	@Override
	public Venta obtenerVentaPorId(Long ID_Venta) {
		
		return ventaRepositorio.findById(ID_Venta).get();
	}

	@Override
	public Venta guardarVenta(Venta venta) {
		
		return ventaRepositorio.save(venta);
	}

	@Override
	public Venta updateVenta(Venta venta) {
		
		return ventaRepositorio.save(venta);
	}

	@Override
	public void delete(Long ID_Venta) {
		
		ventaRepositorio.deleteById(ID_Venta);
		
	}

}
