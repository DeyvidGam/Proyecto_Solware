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
@Table (name="Roles")

public class Rol {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long ID_Rol;
	    @Column(name="Nombre_Rol")
	    private String Nombre_Rol;
	    
	    
	    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
	    List<Usuario>listaUsuarios;
		public Rol() {
			super();
		}
		public Rol(Long iD_Rol, String nombre_Rol) {
			super();
			ID_Rol = iD_Rol;
			Nombre_Rol = nombre_Rol;
		}
		public Long getID_Rol() {
			return ID_Rol;
		}
		public void setID_Rol(Long iD_Rol) {
			ID_Rol = iD_Rol;
		}
		public String getNombre_Rol() {
			return Nombre_Rol;
		}
		public void setNombre_Rol(String nombre_Rol) {
			Nombre_Rol = nombre_Rol;
		}
		@Override
		public String toString() {
			return "Rol [ID_Rol=" + ID_Rol + ", Nombre_Rol=" + Nombre_Rol + "]";
		}
	    
	    
	}

