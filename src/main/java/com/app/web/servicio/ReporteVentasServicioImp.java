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
import com.app.web.entidad.ReporteVentas;

import net.sf.jasperreports.engine.JRException;
@Service
public class ReporteVentasServicioImp implements ReporteVentasServicio{
	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;

	public ReporteVentas obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Reportes_Ventas";
		ReporteVentas dto = new ReporteVentas();
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

	@Override
	public ReporteVentas obtenerReporteVentas(LocalDate fechaInicio, LocalDate fechaFin, TipoReporteEnum tipoReporte) {
		// TODO Auto-generated method stub
		return null;
	}
}
