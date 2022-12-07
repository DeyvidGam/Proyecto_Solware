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
@Table (name="Inventario")

public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Inventario;
    @Column(name="Entrada")
    private int Entrada;
    @Column(name="Salida")
    private int Salida;
    @Column(name="Disponible")
    private int Disponible;
    @Column(name="Fecha")
    private String Fecha;
    @ManyToOne
 	 @JoinColumn (name="Movimiento")
 	 Movimiento movimiento;
     @ManyToOne
 	 @JoinColumn (name="Insumo")
 	 Insumo insumo;
    @OneToMany(mappedBy = "id_Inventario",cascade = CascadeType.ALL)
    List<Produccion>listaProduccionesI;
	public Inventario() {
		super();
	}
	public Inventario(Long iD_Inventario, Movimiento movimiento, Insumo insumo, int entrada, int salida, int disponible,
			String fecha) {
		super();
		ID_Inventario = iD_Inventario;
		this.movimiento = movimiento;
		this.insumo = insumo;
		Entrada = entrada;
		Salida = salida;
		Disponible = disponible;
		Fecha = fecha;
	}
	public Long getID_Inventario() {
		return ID_Inventario;
	}
	public void setID_Inventario(Long iD_Inventario) {
		ID_Inventario = iD_Inventario;
	}
	public Movimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public int getEntrada() {
		return Entrada;
	}
	public void setEntrada(int entrada) {
		Entrada = entrada;
	}
	public int getSalida() {
		return Salida;
	}
	public void setSalida(int salida) {
		Salida = salida;
	}
	public int getDisponible() {
		return Disponible;
	}
	public void setDisponible(int disponible) {
		Disponible = disponible;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	@Override
	public String toString() {
		return "Inventario [ID_Inventario=" + ID_Inventario + ", movimiento=" + movimiento + ", insumo=" + insumo
				+ ", Entrada=" + Entrada + ", Salida=" + Salida + ", Disponible=" + Disponible + ", Fecha=" + Fecha
				+ "]";
	}
	
	
    
}