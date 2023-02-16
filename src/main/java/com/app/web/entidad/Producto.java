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
	@Table(name ="producto")
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Producto;
    @Column(name = "Nombre ")
    private String Nombre;
    @Column(name = "Tamano ")
    private String Tamano;
    @Column(name = "Precio ")
    private int Precio;
    @ManyToOne
	 @JoinColumn (name="Proveedor")
	 Proveedor proveedor;
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    List<Detalle_Pedido>listaProductos;
	public Producto(Long iD_Producto, String nombre, String tamano, int precio, Proveedor proveedor) {
		super();
		ID_Producto = iD_Producto;
		Nombre = nombre;
		Tamano = tamano;
		Precio = precio;
		this.proveedor = proveedor;
	}
	public Producto() {
		super();
	}
	public Long getID_Producto() {
		return ID_Producto;
	}
	public void setID_Producto(Long iD_Producto) {
		ID_Producto = iD_Producto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTamano() {
		return Tamano;
	}
	public void setTamano(String tamano) {
		Tamano = tamano;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	@Override
	public String toString() {
		return "Producto [ID_Producto=" + ID_Producto + ", Nombre=" + Nombre + ", Tamano=" + Tamano + ", Precio="
				+ Precio + ", proveedor=" + proveedor + "]";
	}
   
	
	
  
}
