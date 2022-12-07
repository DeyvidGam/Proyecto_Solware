package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.web.entidad.Detalle_Pedido;


@Repository
public interface Detalle_PedidoRepositorio  extends JpaRepository<Detalle_Pedido,Long>{
	
	public Detalle_Pedido findBy(Class<Detalle_Pedido> aClass, Long ID_Detalle_Pedido);

}
