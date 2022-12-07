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
@Table(name = "Produccion")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Produccion;
    @Column(name = "Fecha_Inicio")
    private String Fecha_Inicio;
    @Column(name = "Cantidad")
    private int Cantidad;
    @Column(name = "Fecha_Fin")
    private String Fecha_Fin;
     @ManyToOne
	 @JoinColumn (name="Operario")
	 Usuario operario;
	 @ManyToOne
	 @JoinColumn (name="Pedido")
	 Pedido pedido;
	 @ManyToOne
	 @JoinColumn (name="ID_Inventario")
	 Inventario id_Inventario;
	 @ManyToOne
	 @JoinColumn (name="Estado_Produccion")
	 Estado estado_Produccion;
    @OneToMany(mappedBy = "produccion", cascade = CascadeType.ALL)
    List<Detalle_Produccion>listaDetalle_Produccion;
	public Produccion() {
		super();
	}
	public Produccion(Long iD_Produccion, String fecha_Inicio, int cantidad, String fecha_Fin, Usuario operario,
			Pedido pedido, Inventario id_Inventario, Estado estado_Produccion) {
		super();
		ID_Produccion = iD_Produccion;
		Fecha_Inicio = fecha_Inicio;
		Cantidad = cantidad;
		Fecha_Fin = fecha_Fin;
		this.operario = operario;
		this.pedido = pedido;
		this.id_Inventario = id_Inventario;
		this.estado_Produccion = estado_Produccion;
	}
	public Long getID_Produccion() {
		return ID_Produccion;
	}
	public void setID_Produccion(Long iD_Produccion) {
		ID_Produccion = iD_Produccion;
	}
	public String getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public void setFecha_Inicio(String fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getFecha_Fin() {
		return Fecha_Fin;
	}
	public void setFecha_Fin(String fecha_Fin) {
		Fecha_Fin = fecha_Fin;
	}
	public Usuario getOperario() {
		return operario;
	}
	public void setOperario(Usuario operario) {
		this.operario = operario;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Inventario getId_Inventario() {
		return id_Inventario;
	}
	public void setId_Inventario(Inventario id_Inventario) {
		this.id_Inventario = id_Inventario;
	}
	public Estado getEstado_Produccion() {
		return estado_Produccion;
	}
	public void setEstado_Produccion(Estado estado_Produccion) {
		this.estado_Produccion = estado_Produccion;
	}

	
	
    
}