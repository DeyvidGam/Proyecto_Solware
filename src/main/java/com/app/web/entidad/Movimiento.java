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
@Table (name="Movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Movimiento;
    @Column(name="Nombre")
    private String Nombre;
    @OneToMany(mappedBy = "movimiento",cascade = CascadeType.ALL)
    List<Inventario>listaInventariosM;
	public Movimiento() {
		super();
	}
	public Movimiento(Long iD_Movimiento, String nombre) {
		super();
		ID_Movimiento = iD_Movimiento;
		Nombre = nombre;
	}
	public Long getID_Movimiento() {
		return ID_Movimiento;
	}
	public void setID_Movimiento(Long iD_Movimiento) {
		ID_Movimiento = iD_Movimiento;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	@Override
	public String toString() {
		return "Movimiento [ID_Movimiento=" + ID_Movimiento + ", Nombre=" + Nombre + "]";
	}
    
}