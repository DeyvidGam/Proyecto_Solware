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
@Table (name="Usuarios")
public class Usuario {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ID_Usuario;
	
	    @Column(name="Nombre")
	    private String Nombre;
	    @Column(name="Apellido")
	    private String Apellido;
	    @Column(name="Correo")
	    private String Correo;
	    @Column(name="telefono")
	    private int telefono;
	    @Column(name="Contrasena")
	    private int Contrasena;
	    @ManyToOne
		 @JoinColumn (name="Rol")
		 private Rol rol;
		 
	    @OneToMany(mappedBy = "operario",cascade = CascadeType.ALL)
	    List<Produccion>listaProducciones;
	    
		public Usuario() {
			super();
		}

		public Usuario(Long iD_Usuario, Rol rol, String nombre, String apellido, String correo, int telefono,
				int contrasena) {
			super();
			ID_Usuario = iD_Usuario;
			this.rol = rol;
			Nombre = nombre;
			Apellido = apellido;
			Correo = correo;
			this.telefono = telefono;
			Contrasena = contrasena;
		}

		public Long getID_Usuario() {
			return ID_Usuario;
		}

		public void setID_Usuario(Long iD_Usuario) {
			ID_Usuario = iD_Usuario;
		}

		public Rol getRol() {
			return rol;
		}

		public void setRol(Rol rol) {
			this.rol = rol;
		}

		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public String getApellido() {
			return Apellido;
		}

		public void setApellido(String apellido) {
			Apellido = apellido;
		}

		public String getCorreo() {
			return Correo;
		}

		public void setCorreo(String correo) {
			Correo = correo;
		}

		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(int telefono) {
			this.telefono = telefono;
		}

		public int getContrasena() {
			return Contrasena;
		}

		public void setContrasena(int contrasena) {
			Contrasena = contrasena;
		}

		@Override
		public String toString() {
			return "Usuario [ID_Usuario=" + ID_Usuario + ", rol=" + rol + ", Nombre=" + Nombre + ", Apellido="
					+ Apellido + ", Correo=" + Correo + ", telefono=" + telefono + ", Contrasena=" + Contrasena + "]";
		}
	    
	    
	}
