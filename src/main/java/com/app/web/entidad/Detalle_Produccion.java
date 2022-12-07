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
@Table(name = "Detalle_Produccion")
	public class Detalle_Produccion {
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ID_Detalle_Produccion;
	    @Column(name = "Cantidad")
	    private String Cantidad;
	    @ManyToOne
		 @JoinColumn (name="Insumo")
	    Insumo insumo;
	    @ManyToOne
		 @JoinColumn (name="Produccion")
	    Produccion produccion;
		public Detalle_Produccion() {
			super();
		}
		public Detalle_Produccion(Long iD_Detalle_Produccion, Insumo insumo, Produccion produccion, String cantidad) {
			super();
			ID_Detalle_Produccion = iD_Detalle_Produccion;
			this.insumo = insumo;
			this.produccion = produccion;
			Cantidad = cantidad;
		}
		public Long getID_Detalle_Produccion() {
			return ID_Detalle_Produccion;
		}
		public void setID_Detalle_Produccion(Long iD_Detalle_Produccion) {
			ID_Detalle_Produccion = iD_Detalle_Produccion;
		}
		public Insumo getInsumo() {
			return insumo;
		}
		public void setInsumo(Insumo insumo) {
			this.insumo = insumo;
		}
		public Produccion getProduccion() {
			return produccion;
		}
		public void setProduccion(Produccion produccion) {
			this.produccion = produccion;
		}
		public String getCantidad() {
			return Cantidad;
		}
		public void setCantidad(String cantidad) {
			Cantidad = cantidad;
		}
		@Override
		public String toString() {
			return "Detalle_Produccion [ID_Detalle_Produccion=" + ID_Detalle_Produccion + ", insumo=" + insumo
					+ ", produccion=" + produccion + ", Cantidad=" + Cantidad + "]";
		}
		
	    
	    
}

