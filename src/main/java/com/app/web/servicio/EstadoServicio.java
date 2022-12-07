package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Estado;



public interface EstadoServicio {


	public List<Estado> listarestados();
    public Estado  obtenerClientePorId(Long ID_Estado);
    public Estado guardarCliente(Estado estado);
    public  Estado updateCliente(Estado estado);
    public void delete(Long ID_Estado);
}
