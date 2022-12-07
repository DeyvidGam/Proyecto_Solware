package com.app.web.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.entidad.Rol;

@Repository
public interface RolRepositorio extends JpaRepository<Rol,Long>  {
    public Rol findBy(Class<Rol> aClass, long id);
}
