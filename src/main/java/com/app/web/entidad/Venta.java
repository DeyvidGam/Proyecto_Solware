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
@Table(name = "Ventas")
public class Venta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Venta;
	
    @Column(name = "FechaYHora")
    private String FechaYHora;
    @Column(name = "Modo_Pago")
    private String Modo_Pago;
    @Column(name = "Valor_Venta")
    private int  Valor_Venta;
    @ManyToOne
	 @JoinColumn (name="IDPedido")
	 Pedido iDPedido;
	public Venta() {
	
	}

	public Venta(Long iD_Venta, Pedido iDPedido, String fechaYHora, String modo_Pago, int valor_Venta) {
		super();
		ID_Venta = iD_Venta;
		this.iDPedido = iDPedido;
		FechaYHora = fechaYHora;
		Modo_Pago = modo_Pago;
		Valor_Venta = valor_Venta;
	}

	public Long getID_Venta() {
		return ID_Venta;
	}

	public void setID_Venta(Long iD_Venta) {
		ID_Venta = iD_Venta;
	}

	public Pedido getiDPedido() {
		return iDPedido;
	}

	public void setiDPedido(Pedido iDPedido) {
		this.iDPedido = iDPedido;
	}

	public String getFechaYHora() {
		return FechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		FechaYHora = fechaYHora;
	}

	public String getModo_Pago() {
		return Modo_Pago;
	}

	public void setModo_Pago(String modo_Pago) {
		Modo_Pago = modo_Pago;
	}

	public int getValor_Venta() {
		return Valor_Venta;
	}

	public void setValor_Venta(int valor_Venta) {
		Valor_Venta = valor_Venta;
	}

	@Override
	public String toString() {
		return "Venta [ID_Venta=" + ID_Venta + ", iDPedido=" + iDPedido + ", FechaYHora=" + FechaYHora + ", Modo_Pago="
				+ Modo_Pago + ", Valor_Venta=" + Valor_Venta + "]";
	}
	
    
    
    
	
	

}
