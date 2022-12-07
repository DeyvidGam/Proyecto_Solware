package com.app.web.servicio;

import java.util.List;

import com.app.web.entidad.Inventario;

public interface InventarioServicio {
    public List<Inventario> listarinventario();
    public Inventario obtenerInventarioPorId(Long ID_Inventario);
    public Inventario guardarInventario(Inventario inventario);
    public Inventario updateInventario(Inventario inventario);
    public void delete(Long ID_Inventario); 
}
