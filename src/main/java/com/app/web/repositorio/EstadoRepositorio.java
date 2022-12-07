package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Estado;


@Repository
public interface EstadoRepositorio extends JpaRepository<Estado,Long>{

	public Estado findBy(Class<Estado> aClass, Long ID_Estado);
}
