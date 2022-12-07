package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Proveedor;


@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor,Long>{
	
	public Proveedor findBy(Class<Proveedor> aClass, Long ID_Proveedor);


}
