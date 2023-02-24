package com.app.web.servicio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import com.app.web.entidad.ReporteInventario;
import net.sf.jasperreports.engine.JRException;

public interface ReporteInventarioServicio {
	ReporteInventario obtenerReporteInventario(Map<String, Object> params) throws JRException, IOException, SQLException;

}
