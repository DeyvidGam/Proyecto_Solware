package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Detalle_Produccion;

public interface Detalle_ProduccionServicio {
	
	  public List<Detalle_Produccion> listardetalle_Produccion();
	    public Detalle_Produccion obtenerDetalle_ProduccionPorId(Long ID_Detalle_Produccion);
	    public Detalle_Produccion guardarDetalle_Produccion(Detalle_Produccion detalle_Produccion);
	    public Detalle_Produccion updateDetalle_Produccion(Detalle_Produccion detalle_Produccion);
	    public void delete(Long ID_Detalle_Produccion);
}
