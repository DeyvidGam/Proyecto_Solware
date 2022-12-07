package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Rol;
import com.app.web.repositorio.RolRepositorio;

@Service
public class RolServicioImp implements RolServicio{
	 @Autowired
	    private RolRepositorio rolRepositorio;

		@Override
		public List<Rol> listarrol() {
			return rolRepositorio.findAll();
		}

		@Override
		public Rol obtenerRolPorId(Long ID_Rol) {
			return rolRepositorio.findById(ID_Rol).get();
		}

		@Override
		public Rol guardarRol(Rol rol) {
			return rolRepositorio.save(rol);
		}

		@Override
		public Rol updateRol(Rol rol) {
		
			return rolRepositorio.save(rol);
		}

		@Override
		public void delete(Long ID_Rol) {
			
			rolRepositorio.deleteById(ID_Rol);
		}
		
}
