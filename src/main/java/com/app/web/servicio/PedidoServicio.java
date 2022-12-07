package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Pedido;



public interface PedidoServicio {
	
	

	public List<Pedido> listarpedidos();
    public Pedido  obtenerPedidoPorId(Long ID_Pedido);
    public Pedido guardarPedido(Pedido pedido);
    public  Pedido updatePedido(Pedido pedido);
    public void delete(Long ID_Pedido);

}
