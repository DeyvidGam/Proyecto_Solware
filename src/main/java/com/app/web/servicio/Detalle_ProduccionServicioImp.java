package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Detalle_Produccion;
import com.app.web.repositorio.Detalle_ProduccionRepositorio;
@Service
public class Detalle_ProduccionServicioImp implements Detalle_ProduccionServicio{
	 @Autowired
	    private Detalle_ProduccionRepositorio detalle_ProduccionRepositorio;

	@Override
	public List<Detalle_Produccion> listardetalle_Produccion() {
		
		return detalle_ProduccionRepositorio.findAll();
	}

	@Override
	public Detalle_Produccion obtenerDetalle_ProduccionPorId(Long ID_Detalle_Produccion) {
		
		return detalle_ProduccionRepositorio.findById(ID_Detalle_Produccion).get();
	}

	@Override
	public Detalle_Produccion guardarDetalle_Produccion(Detalle_Produccion detalle_Produccion) {
		
		return detalle_ProduccionRepositorio.save(detalle_Produccion);
	}

	@Override
	public Detalle_Produccion updateDetalle_Produccion(Detalle_Produccion detalle_Produccion) {
		
		return detalle_ProduccionRepositorio.save(detalle_Produccion);
	}

	@Override
	public void delete(Long ID_Detalle_Produccion) {
		detalle_ProduccionRepositorio.deleteById(ID_Detalle_Produccion);
	}

}
