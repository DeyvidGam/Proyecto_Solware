package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Insumo;
@Repository
public interface InsumoRepositorio extends JpaRepository<Insumo,Long> {
    
    public Insumo findBy(Class<Insumo> aClass, long id);

}
