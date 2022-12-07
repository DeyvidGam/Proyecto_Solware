package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Inventario;
import com.app.web.repositorio.InventarioRepositorio;

@Service
public class InventarioServicioImp implements InventarioServicio{
	 @Autowired
	    private InventarioRepositorio inventarioRepositorio;


		@Override
		public List<Inventario> listarinventario() {
			
			return inventarioRepositorio.findAll();
		}

		@Override
		public Inventario obtenerInventarioPorId(Long ID_Inventario) {
			
			return inventarioRepositorio.findById(ID_Inventario).get();
		}

		@Override
		public Inventario guardarInventario(Inventario inventario) {
			
			return inventarioRepositorio.save(inventario);
		}

		@Override
		public Inventario updateInventario(Inventario inventario) {
			
			return inventarioRepositorio.save(inventario);
		}

		@Override
		public void delete(Long ID_Inventario) {
			
			inventarioRepositorio.deleteById(ID_Inventario);
		}
}
