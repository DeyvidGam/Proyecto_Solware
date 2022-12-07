package com.app.web.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Estados")
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Estado;
    @Column(name = "Tipo_Estado ")
    private String Tipo_Estado;
    @OneToMany(mappedBy = "estadoInsumo",cascade = CascadeType.ALL)
    List<Insumo>listaEstadoInsumo;
    @OneToMany(mappedBy = "estado_Produccion",cascade = CascadeType.ALL)
    List<Produccion>listaProduccion;
	public Estado() {
		
	}
	public Estado(Long iD_Estado, String tipo_Estado) {
		
		ID_Estado = iD_Estado;
		Tipo_Estado = tipo_Estado;
	}
	public Long getID_Estado() {
		return ID_Estado;
	}
	public void setID_Estado(Long iD_Estado) {
		ID_Estado = iD_Estado;
	}
	public String getTipo_Estado() {
		return Tipo_Estado;
	}
	public void setTipo_Estado(String tipo_Estado) {
		Tipo_Estado = tipo_Estado;
	}
	@Override
	public String toString() {
		return "Estado [ID_Estado=" + ID_Estado + ", Tipo_Estado=" + Tipo_Estado + "]";
	}
    
    
    
    
    

}
