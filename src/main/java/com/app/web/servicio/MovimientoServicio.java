package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Movimiento;

public interface MovimientoServicio {
	public List<Movimiento> listarmovimiento();
    public Movimiento obtenerMovimientoPorId(Long ID_Movimiento);
    public Movimiento guardarMovimiento(Movimiento movimiento);
    public Movimiento updateMovimiento(Movimiento movimiento);
    public void delete(Long ID_Movimiento);
}
