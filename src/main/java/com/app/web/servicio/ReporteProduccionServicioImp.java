package com.app.web.servicio;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.Enum.TipoReporteEnum;
import com.app.web.commons.JasperReportManager;
import com.app.web.entidad.ReporteInventario;
import com.app.web.entidad.ReporteProduccion;

import net.sf.jasperreports.engine.JRException;
@Service
public class ReporteProduccionServicioImp implements ReporteProduccionServicio{
	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	@Override
	public ReporteProduccion obtenerReporteProduccion(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Reportes_Produccion";
		ReporteProduccion dto = new ReporteProduccion();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}


}
