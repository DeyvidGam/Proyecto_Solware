package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Detalle_Pedido")
public class Detalle_Pedido {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Detalle_Pedido;
    @Column(name = "Cantidad")
    private int Cantidad;
    @Column(name = "SubTotal")
    private int SubTotal;
	@ManyToOne
	 @JoinColumn (name="Pedido")
	 Pedido pedido;
	@ManyToOne
	@JoinColumn (name="Producto")
	 Producto producto;
	public Detalle_Pedido(Long iD_Detalle_Pedido, int cantidad, int subTotal, Pedido pedido, Producto producto) {
		super();
		ID_Detalle_Pedido = iD_Detalle_Pedido;
		Cantidad = cantidad;
		SubTotal = subTotal;
		this.pedido = pedido;
		this.producto = producto;
	}
	public Detalle_Pedido() {
		super();
	}
	public Long getID_Detalle_Pedido() {
		return ID_Detalle_Pedido;
	}
	public void setID_Detalle_Pedido(Long iD_Detalle_Pedido) {
		ID_Detalle_Pedido = iD_Detalle_Pedido;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public int getSubTotal() {
		return SubTotal;
	}
	public void setSubTotal(int subTotal) {
		SubTotal = subTotal;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Detalle_Pedido [ID_Detalle_Pedido=" + ID_Detalle_Pedido + ", Cantidad=" + Cantidad + ", SubTotal="
				+ SubTotal + ", pedido=" + pedido + ", producto=" + producto + "]";
	}
	
	
    
}
