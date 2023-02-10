package com.app.web.entidad;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name="Cantidad")
    private int Cantidad;
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
	public Inventario(Long iD_Inventario, int cantidad, String fecha, Movimiento movimiento, Insumo insumo) {
		super();
		ID_Inventario = iD_Inventario;
		Cantidad = cantidad;
		Fecha = fecha;
		this.movimiento = movimiento;
		this.insumo = insumo;
	}
	public Long getID_Inventario() {
		return ID_Inventario;
	}
	public void setID_Inventario(Long iD_Inventario) {
		ID_Inventario = iD_Inventario;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
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
	@Override
	public String toString() {
		return "Inventario [ID_Inventario=" + ID_Inventario + ", Cantidad=" + Cantidad + ", Fecha=" + Fecha
				+ ", movimiento=" + movimiento + ", insumo=" + insumo + "]";
	}
	

	
    
}