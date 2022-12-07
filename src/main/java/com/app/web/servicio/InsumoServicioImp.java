package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.web.entidad.Insumo;
import com.app.web.repositorio.InsumoRepositorio;
@Service
public class InsumoServicioImp implements InsumoServicio{
	@Autowired
    private InsumoRepositorio insumoRepositorio;

	@Override
	public List<Insumo> listarinsumo() {
		
		return insumoRepositorio.findAll();
	}

	@Override
	public Insumo obtenerInsumoPorId(Long ID_Insumo) {
		
		return insumoRepositorio.findById(ID_Insumo).get();
	}

	@Override
	public Insumo guardarInsumo(Insumo insumo) {
		return insumoRepositorio.save(insumo);
	}

	@Override
	public Insumo updateInsumo(Insumo insumo) {
		
		return insumoRepositorio.save(insumo);
	}

	@Override
	public void delete(Long ID_Insumo) {
		insumoRepositorio.deleteById(ID_Insumo);
	}

}
