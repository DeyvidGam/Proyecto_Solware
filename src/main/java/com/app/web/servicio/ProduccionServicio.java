package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Produccion;

public interface ProduccionServicio {
	 public List<Produccion> listarproduccion();
	    public Produccion obtenerProduccionPorId(Long ID_Produccion);
	    public Produccion guardarProduccion(Produccion produccion);
	    public Produccion updateProduccion(Produccion produccion);
	    public void delete(Long ID_Produccion);
}
