package com.app.web.controlador;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.web.Enum.TipoReporteEnum;
import com.app.web.entidad.ReporteVentas;
import com.app.web.servicio.ReporteVentasServicio;

import net.sf.jasperreports.engine.JRException;
@Controller
@RequestMapping(path="/Solware2/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
public class ReporteVentasControlador {
    @Autowired
    private ReporteVentasServicio reporteVentasServicio;

    @GetMapping("/ventas/download")
    public ResponseEntity<Resource> generarReporteVentasArchivo(@RequestParam Map<String, Object> params)
            throws JRException, IOException, SQLException {
        ReporteVentas dto = reporteVentasServicio.obtenerReporteVentas(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        } 

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }
    @GetMapping("/ventas")
    public String generarReporteVentas(Model model,
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaFin") LocalDate fechaFin,
            @RequestParam("tipo") TipoReporteEnum tipoReporte)
            throws JRException, IOException, SQLException {
        ReporteVentas dto = reporteVentasServicio.obtenerReporteVentas(fechaInicio, fechaFin, tipoReporte);

        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("tipoReporte", tipoReporte.name());
        model.addAttribute("reporteStream", new InputStreamResource(dto.getStream()));
        model.addAttribute("reporteFileName", dto.getFileName());

        return "reporteVentas";
    }


    
}
