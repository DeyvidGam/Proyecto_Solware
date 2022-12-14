package com.app.web.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pedidos")
public class Pedido {
	
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Pedido;
	
    @Column(name = "Fecha_Pedido ")
    private String Fecha_Pedido;
    @Column(name = "Total ")
    private int Total;
    @ManyToOne
	 @JoinColumn (name="ID_Cliente")
	 Cliente cliente;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    List<Produccion>listaProduccion;
    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    List<Detalle_Pedido>listaDetallePedido;
    @OneToMany(mappedBy = "iDPedido",cascade = CascadeType.ALL)
    List<Venta>listaVentas;
	public Pedido() {
	
	}
	public Pedido(Long iD_Pedido, Cliente cliente, String fecha_Pedido, int total) {
		super();
		ID_Pedido = iD_Pedido;
		this.cliente = cliente;
		Fecha_Pedido = fecha_Pedido;
		Total = total;
	}
	public Long getID_Pedido() {
		return ID_Pedido;
	}
	public void setID_Pedido(Long iD_Pedido) {
		ID_Pedido = iD_Pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getFecha_Pedido() {
		return Fecha_Pedido;
	}
	public void setFecha_Pedido(String fecha_Pedido) {
		Fecha_Pedido = fecha_Pedido;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	@Override
	public String toString() {
		return "Pedido [ID_Pedido=" + ID_Pedido + ", cliente=" + cliente + ", Fecha_Pedido=" + Fecha_Pedido + ", Total="
				+ Total + "]";
	}
	
	
	
	
    
    
    
    
	
	

}
