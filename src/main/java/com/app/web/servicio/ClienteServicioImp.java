package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Cliente;
import com.app.web.repositorio.ClienteRepositorio;
@Service
public class ClienteServicioImp implements ClienteServicio{
	  @Autowired
	    private ClienteRepositorio clienteRepositorio;


	@Override
	public List<Cliente> listarclientes() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente obtenerClientePorId(Long Identificacion) {
        return clienteRepositorio.findById(Identificacion).get();
	}

	@Override
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public void delete(Long Identificacion) {
		 clienteRepositorio.deleteById(Identificacion);
		
	}

	

   
  

}
