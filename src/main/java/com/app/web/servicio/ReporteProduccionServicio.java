package com.app.web.servicio;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import com.app.web.Enum.TipoReporteEnum;
import com.app.web.entidad.ReporteInventario;
import com.app.web.entidad.ReporteProduccion;

import net.sf.jasperreports.engine.JRException;

public interface ReporteProduccionServicio {
	ReporteProduccion obtenerReporteProduccion(Map<String, Object> params) throws JRException, IOException, SQLException;

}
