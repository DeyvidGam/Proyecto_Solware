package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Inventario;
@Repository
public interface InventarioRepositorio extends JpaRepository<Inventario,Long> {
    public Inventario findBy(Class<Inventario> aClass, long id);

}
