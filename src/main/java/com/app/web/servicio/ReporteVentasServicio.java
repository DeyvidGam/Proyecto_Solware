package com.app.web.servicio;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import com.app.web.Enum.TipoReporteEnum;
import com.app.web.entidad.ReporteVentas;

import net.sf.jasperreports.engine.JRException;

public interface ReporteVentasServicio {
	ReporteVentas obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;

	ReporteVentas obtenerReporteVentas(LocalDate fechaInicio, LocalDate fechaFin, TipoReporteEnum tipoReporte);

}
