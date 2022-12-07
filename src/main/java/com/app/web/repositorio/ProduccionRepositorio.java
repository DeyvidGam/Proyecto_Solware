package com.app.web.repositorio;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Produccion;


@Repository
public interface ProduccionRepositorio extends JpaRepository<Produccion,Long>{
 
    public Produccion findBy(Class<Produccion> aClass, long id);
}