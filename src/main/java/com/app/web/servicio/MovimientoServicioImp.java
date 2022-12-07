package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Movimiento;
import com.app.web.repositorio.MovimientoRepositorio;

@Service
public class MovimientoServicioImp implements MovimientoServicio {
	 @Autowired
	    private MovimientoRepositorio movimientoRepositorio;



		@Override
		public List<Movimiento> listarmovimiento() {
			return movimientoRepositorio.findAll();
		}

		@Override
		public Movimiento obtenerMovimientoPorId(Long ID_Movimiento) {
			return movimientoRepositorio.findById(ID_Movimiento).get();
		}

		@Override
		public Movimiento guardarMovimiento(com.app.web.entidad.Movimiento movimiento) {
			return movimientoRepositorio.save(movimiento);
		}

		@Override
		public Movimiento updateMovimiento(com.app.web.entidad.Movimiento movimiento) {
			return movimientoRepositorio.save(movimiento);
		}

		@Override
		public void delete(Long ID_Movimiento) {
			movimientoRepositorio.deleteById(ID_Movimiento);
		}
}
