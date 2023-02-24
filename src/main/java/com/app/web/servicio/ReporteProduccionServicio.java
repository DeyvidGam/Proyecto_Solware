package com.app.web.servicio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import com.app.web.entidad.ReporteProduccion;

import net.sf.jasperreports.engine.JRException;

public interface ReporteProduccionServicio {
	ReporteProduccion obtenerReporteProduccion(Map<String, Object> params) throws JRException, IOException, SQLException;

}
