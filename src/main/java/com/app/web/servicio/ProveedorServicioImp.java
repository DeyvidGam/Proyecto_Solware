package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.web.entidad.Proveedor;
import com.app.web.repositorio.ProveedorRepositorio;


@Service
public class ProveedorServicioImp implements ProveedorServicio{

	  @Autowired
	    private ProveedorRepositorio proveedorRepositorio;

	    private Proveedor proveedor;

		@Override
		public List<Proveedor> listarproveedores() {
			
			return proveedorRepositorio.findAll();
		}

		@Override
		public Proveedor obtenerProveedorPorId(Long ID_Proveedor) {
			
			return proveedorRepositorio.findById(ID_Proveedor).get();
		}

		@Override
		public Proveedor guardarProveedor(Proveedor proveedor) {
			
			return proveedorRepositorio.save(proveedor);
		}

		@Override
		public Proveedor updateProveedor(Proveedor proveedor) {
			
			return proveedorRepositorio.save(proveedor);
		}

		@Override
		public void delete(Long ID_Proveedor) {
			proveedorRepositorio.deleteById(ID_Proveedor);
			
		}
	
	

}
