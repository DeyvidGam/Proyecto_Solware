package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Produccion;
import com.app.web.repositorio.ProduccionRepositorio;


@Service
public class ProduccionServicioImp implements ProduccionServicio{
	  @Autowired
	    private ProduccionRepositorio produccionRepositorio;


		@Override
		public List<Produccion> listarproduccion() {
			return produccionRepositorio.findAll();
		}

		@Override
		public Produccion obtenerProduccionPorId(Long ID_Produccion) {
			return produccionRepositorio.findById(ID_Produccion).get();
		}

		@Override
		public Produccion guardarProduccion(Produccion produccion) {
			return produccionRepositorio.save(produccion);
		}

		@Override
		public Produccion updateProduccion(Produccion produccion) {
			return produccionRepositorio.save(produccion);
		}

		@Override
		public void delete(Long ID_Produccion) {
			produccionRepositorio.deleteById(ID_Produccion);
		}
}
