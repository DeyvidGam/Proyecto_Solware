package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
     public Usuario findBy(Class<Usuario> aClass, long id);
}
