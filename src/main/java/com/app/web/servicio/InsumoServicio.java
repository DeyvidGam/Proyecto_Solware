package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Insumo;

public interface InsumoServicio {
	  	public List<Insumo> listarinsumo(); 
	    public Insumo obtenerInsumoPorId(Long ID_Insumo);
	    public Insumo guardarInsumo(Insumo insumo);
	    public Insumo updateInsumo(Insumo insumo);
	    public void delete(Long ID_Insumo);
}
