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
@Table(name ="cliente")
public class Cliente {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Identificacion;
	    @Column(name="Nombres")
	    private String Nombres;
	    @Column(name="Apellidos")
	    private String Apellidos;
	    @Column(name="Email")
	    private String Email;
	    @Column(name="telefono")
	    private String Telefono;
	    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
	    List<Pedido>listaPedido;
	
		public Cliente() {
		}
		public Cliente(Long identificacion, String nombres, String apellidos, String email, String telefono) {
			super();
			Identificacion = identificacion;
			Nombres = nombres;
			Apellidos = apellidos;
			Email = email;
			Telefono = telefono;
		}
		public Cliente(String nombres, String apellidos, String email, String telefono) {
			super();

			Nombres = nombres;
			Apellidos = apellidos;
			Email = email;
			Telefono = telefono;
		}
		@Override
		public String toString() {
			return "Cliente [Identificacion=" + Identificacion + ", Nombres=" + Nombres + ", Apellidos=" + Apellidos
					+ ", Email=" + Email + ", telefono=" + Telefono + "]";
		} 
		
		public Long getIdentificacion() {
			return Identificacion;
		}
		public void setIdentificacion(Long identificacion) {
			Identificacion = identificacion;
		}
		public String getNombres() {
			return Nombres;
		}
		public void setNombres(String nombres) {
			Nombres = nombres;
		}
		public String getApellidos() {
			return Apellidos;
		}
		public void setApellidos(String apellidos) {
			Apellidos = apellidos;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		public String getTelefono() {
			return Telefono;
		}
		public void setTelefono(String telefono) {
			Telefono = telefono;
		}
	    
	}

