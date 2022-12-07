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
	@Table(name ="producto")
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID_Producto;
    @Column(name = "Nombre ")
    private String Nombre;
    @Column(name = "Proveedor ")
    private String Proveedor;
    @Column(name = "Tamano ")
    private String Tamano;
    @Column(name = "Precio ")
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    List<Proveedor>listaProvedor;
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    List<Detalle_Pedido>listaProductos;
    private int Precio;
	public Producto(Long iD_Producto, String nombre, String proveedor, String tamano,
			List<com.app.web.entidad.Proveedor> listaProvedor, List<Detalle_Pedido> listaProductos, int precio) {
		super();
		ID_Producto = iD_Producto;
		Nombre = nombre;
		Proveedor = proveedor;
		Tamano = tamano;
		this.listaProvedor = listaProvedor;
		this.listaProductos = listaProductos;
		Precio = precio;
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
	public String getProveedor() {
		return Proveedor;
	}
	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}
	public String getTamano() {
		return Tamano;
	}
	public void setTamano(String tamano) {
		Tamano = tamano;
	}
	public List<Proveedor> getListaProvedor() {
		return listaProvedor;
	}
	public void setListaProvedor(List<Proveedor> listaProvedor) {
		this.listaProvedor = listaProvedor;
	}
	public List<Detalle_Pedido> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<Detalle_Pedido> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}
	@Override
	public String toString() {
		return "Producto [ID_Producto=" + ID_Producto + ", Nombre=" + Nombre + ", Proveedor=" + Proveedor + ", Tamano="
				+ Tamano + ", listaProvedor=" + listaProvedor + ", listaProductos=" + listaProductos + ", Precio="
				+ Precio + "]";
	}
	
  
}
