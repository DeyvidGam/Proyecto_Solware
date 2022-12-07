package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Detalle_Produccion;
@Repository
public interface Detalle_ProduccionRepositorio extends JpaRepository<Detalle_Produccion,Long>{
	 public Detalle_Produccion findBy(Class<Detalle_Produccion> aClass, long id);
}
