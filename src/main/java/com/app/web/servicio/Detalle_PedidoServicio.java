package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Detalle_Pedido;



public interface Detalle_PedidoServicio {
	
	public List<Detalle_Pedido> listarDetalle_Pedido();
    public Detalle_Pedido  obtenerDetalle_PedidoPorId(Long ID_Detalle_Pedido);
    public Detalle_Pedido guardarDetalle_Pedido(Detalle_Pedido detalle_Pedido);
    public  Detalle_Pedido updateDetalle_Pedido(Detalle_Pedido detalle_Pedido);
    public void delete(Long ID_Detalle_Pedido);

}
