package com.app.web.servicio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.app.web.entidad.ReporteVentas;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentasServicio {
	ReporteVentas obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;

}
