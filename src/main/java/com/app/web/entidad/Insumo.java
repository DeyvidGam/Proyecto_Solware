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
    @Column(name="Disponible")
    private int Disponible;
    @ManyToOne
	@JoinColumn (name="Estado_Insumo")
    
	 Estado estado_Insumo;
    
    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL)
    List<Detalle_Produccion>listaDetalle_ProduccionIns;

	public Insumo(Long iD_Insumo, String nombre_Material, int disponible, Estado estado_Insumo) {
		super();
		ID_Insumo = iD_Insumo;
		Nombre_Material = nombre_Material;
		Disponible = disponible;
		this.estado_Insumo = estado_Insumo;
	}
	

	public Insumo() {
		super();
	}


	public Long getID_Insumo() {
		return ID_Insumo;
	}

	public void setID_Insumo(Long iD_Insumo) {
		ID_Insumo = iD_Insumo;
	}

	public String getNombre_Material() {
		return Nombre_Material;
	}

	public void setNombre_Material(String nombre_Material) {
		Nombre_Material = nombre_Material;
	}

	public int getDisponible() {
		return Disponible;
	}

	public void setDisponible(int disponible) {
		Disponible = disponible;
	}

	public Estado getEstado_Insumo() {
		return estado_Insumo;
	}

	public void setEstado_Insumo(Estado estado_Insumo) {
		this.estado_Insumo = estado_Insumo;
	}


	@Override
	public String toString() {
		return "Insumo [ID_Insumo=" + ID_Insumo + ", Nombre_Material=" + Nombre_Material + ", Disponible=" + Disponible
				+ ", estado_Insumo=" + estado_Insumo + "]";
	}

	
	
	
	
}