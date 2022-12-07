package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Rol;

public interface RolServicio {
	  	public List<Rol> listarrol();
	    public Rol obtenerRolPorId(Long ID_Rol);
	    public Rol guardarRol(Rol rol);
	    public Rol updateRol(Rol rol);
	    public void delete(Long ID_Rol);
	   
}
