package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.web.entidad.Estado;
import com.app.web.repositorio.EstadoRepositorio;


public class EstadoServicioImp implements EstadoServicio{

	 @Autowired
	    private EstadoRepositorio estadoRepositorio;
	
	@Override
	public List<Estado> listarestados() {
		
		return estadoRepositorio.findAll();
	}

	@Override
	public Estado obtenerClientePorId(Long ID_Estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado guardarCliente(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado updateCliente(Estado estado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long ID_Estado) {
		// TODO Auto-generated method stub
		
	}

}
