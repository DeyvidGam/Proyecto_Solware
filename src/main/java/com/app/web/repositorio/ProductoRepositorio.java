package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Producto;
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto,Long> {

	  public Producto findBy(Class<Producto> aClass, Long ID_Producto);
}
