package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.app.web.entidad.Pedido;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido,Long> {
	
	public Pedido findBy(Class<Pedido> aClass, Long ID_Pedido);

}
