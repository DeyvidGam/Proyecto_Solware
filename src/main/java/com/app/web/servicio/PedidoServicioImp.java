package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Pedido;
import com.app.web.repositorio.PedidoRepositorio;

@Service
public class PedidoServicioImp implements PedidoServicio{

	@Autowired
    private PedidoRepositorio pedidoRepositorio;

    private Pedido pedido;
	
	@Override
	public List<Pedido> listarpedidos() {
		
		return pedidoRepositorio.findAll();
	}

	@Override
	public Pedido obtenerPedidoPorId(Long ID_Pedido) {
	
		return pedidoRepositorio.findById(ID_Pedido).get();
	}

	@Override
	public Pedido guardarPedido(Pedido pedido) {
		
		return pedidoRepositorio.save(pedido);
	}

	@Override
	public Pedido updatePedido(Pedido pedido) {
		
		return pedidoRepositorio.save(pedido);
	}

	@Override
	public void delete(Long ID_Pedido) {
		
		pedidoRepositorio.deleteById(ID_Pedido);
		
	}

}
