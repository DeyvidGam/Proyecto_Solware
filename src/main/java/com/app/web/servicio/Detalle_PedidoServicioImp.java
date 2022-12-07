package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Detalle_Pedido;
import com.app.web.repositorio.Detalle_PedidoRepositorio;




@Service
public class Detalle_PedidoServicioImp implements Detalle_PedidoServicio{

	
	@Autowired
    private Detalle_PedidoRepositorio detalle_PedidoRepositorio;

    private Detalle_Pedido detalle_Pedido;

	@Override
	public List<Detalle_Pedido> listarDetalle_Pedido() {
		
		return detalle_PedidoRepositorio.findAll();
	}

	@Override
	public Detalle_Pedido obtenerDetalle_PedidoPorId(Long ID_Detalle_Pedido) {
		// TODO Auto-generated method stub
		return detalle_PedidoRepositorio.findById(ID_Detalle_Pedido).get();
	}

	@Override
	public Detalle_Pedido guardarDetalle_Pedido(Detalle_Pedido detalle_Pedido) {
		// TODO Auto-generated method stub
		return detalle_PedidoRepositorio.save(detalle_Pedido);
	}

	@Override
	public Detalle_Pedido updateDetalle_Pedido(Detalle_Pedido detalle_Pedido) {
		// TODO Auto-generated method stub
		return detalle_PedidoRepositorio.save(detalle_Pedido);
	}

	@Override
	public void delete(Long ID_Detalle_Pedido) {
		detalle_PedidoRepositorio.deleteById(ID_Detalle_Pedido);
		
	}
}
