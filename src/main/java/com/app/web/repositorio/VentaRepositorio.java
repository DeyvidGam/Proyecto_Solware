package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Venta;


@Repository
public interface VentaRepositorio  extends JpaRepository<Venta,Long>{

	public Venta findBy(Class<Venta> aClass, Long ID_Venta);
}
