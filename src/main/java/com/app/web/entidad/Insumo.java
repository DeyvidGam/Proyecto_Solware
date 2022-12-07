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
@Table (name="Insumos")

public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Insumo;
    @Column(name="Nombre_Material")
    private String Nombre_Material;
    @ManyToOne
	@JoinColumn (name="EstadoInsumo")
    
	 Estado estadoInsumo;
    
    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL)
    List<Detalle_Produccion>listaDetalle_ProduccionIns;
	public Insumo() {
		super();
	}
	public Insumo(Long iD_Insumo, Estado estadoInsumo, String nombre_Material,
			List<Detalle_Produccion> listaDetalle_ProduccionIns) {
		super();
		ID_Insumo = iD_Insumo;
		this.estadoInsumo = estadoInsumo;
		Nombre_Material = nombre_Material;
		this.listaDetalle_ProduccionIns = listaDetalle_ProduccionIns;
	}
	public Long getID_Insumo() {
		return ID_Insumo;
	}
	public void setID_Insumo(Long iD_Insumo) {
		ID_Insumo = iD_Insumo;
	}
	public Estado getEstadoInsumo() {
		return estadoInsumo;
	}
	public void setEstadoInsumo(Estado estadoInsumo) {
		this.estadoInsumo = estadoInsumo;
	}
	public String getNombre_Material() {
		return Nombre_Material;
	}
	public void setNombre_Material(String nombre_Material) {
		Nombre_Material = nombre_Material;
	}
	@Override
	public String toString() {
		return "Insumo [ID_Insumo=" + ID_Insumo + ", estadoInsumo=" + estadoInsumo + ", Nombre_Material="
				+ Nombre_Material + "]";
	}
	
}