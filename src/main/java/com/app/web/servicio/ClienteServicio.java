package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Cliente;

public interface ClienteServicio {
	
	public List<Cliente> listarclientes();
    public Cliente  obtenerClientePorId(Long Identificacion);
    public Cliente guardarCliente(Cliente cliente);
    public  Cliente updateCliente(Cliente cliente);
    public void delete(Long Identificacion);
}
