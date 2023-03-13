package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
     
	
	Usuario findByCorreo(String correo);
   
    
}
