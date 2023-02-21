package com.app.web.controlador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.web.entidad.Inventario;
import com.app.web.entidad.Movimiento;
import com.app.web.servicio.InsumoServicio;
import com.app.web.entidad.Insumo;
import com.app.web.servicio.InventarioServicio;
import com.app.web.servicio.MovimientoServicio;

@Controller
@RequestMapping(path="/Solware2/home")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})

public class InventarioControlador {
	private a;
	@Autowired
	private InventarioServicio inventarioServicio;
	@Autowired
	private  InsumoServicio insumoServicio;
	@Autowired
	private MovimientoServicio movimientoServicio;

	@GetMapping("/Consultar")

	public String listarinventario(Model modelo) {
		modelo.addAttribute("Inventario", inventarioServicio.listarinventario());
		return "Consultar";
	}

	@GetMapping("/ModuloInventario")
	public String crearInventario(Model modelo) {
		Inventario inventario = new Inventario();

		List<Insumo> listainsumos = insumoServicio.listarinsumo();
		List<Movimiento> listamovimientos = movimientoServicio.listarmovimiento();

		modelo.addAttribute("Inventario", inventario);

		modelo.addAttribute("insumos", listainsumos);
		modelo.addAttribute("movimientos", listamovimientos);
		return "ModuloInventario";

	}

	public void MovimientoInventario(Inventario inventario) {
	    inventarioServicio.guardarInventario(inventario);
	    Inventario inventarioExistente = inventarioServicio.obtenerInventarioPorId(inventario.getID_Inventario());
	    Insumo insumo = insumoServicio.obtenerInsumoPorId(inventarioExistente.getInsumo().getID_Insumo());
	    int disponible = insumo.getDisponible();

	    if (inventario.getMovimiento().getNombre().equalsIgnoreCase("Entrada")) {
	        insumo.setDisponible(inventarioExistente.getCantidad() + disponible);
	    } else if (inventario.getMovimiento().getNombre().equalsIgnoreCase("Salida")) {
	        if (disponible >= inventarioExistente.getCantidad()) {
	            insumo.setDisponible(disponible - inventarioExistente.getCantidad());
	        } else {
	            throw new RuntimeException("No hay suficientes insumos disponibles");
	        }
	    }
	    insumoServicio.guardarInsumo(insumo);
	}
	@Transactional
	@PostMapping("/Consultar")
	public String guardarInventario(@ModelAttribute("Inventario") Inventario inventario, Model modelo, RedirectAttributes attributes) {
		try {
	        MovimientoInventario(inventario);
	        attributes.addFlashAttribute("exitoso", "Registro Exitoso");
	        return "redirect:/Solware2/home/ModuloInventario";
	    } catch (RuntimeException e) {
	        modelo.addAttribute("mensaje", e.getMessage());
	        List<Insumo> listainsumos = insumoServicio.listarinsumo();
	        List<Movimiento> listamovimientos = movimientoServicio.listarmovimiento();
	        modelo.addAttribute("Inventario", inventario);
	        modelo.addAttribute("insumos", listainsumos);
	        modelo.addAttribute("movimientos", listamovimientos);
	        return "ModuloInventario";
	    }
		
	}


	@GetMapping("/Consultar/editar/{ID_Inventario}")
	public String Editar(@PathVariable Long ID_Inventario,Model modelo ) {
		List<Insumo> listainsumos = insumoServicio.listarinsumo();
		List<Movimiento> listamovimientos = movimientoServicio.listarmovimiento();
		modelo.addAttribute("insumos", listainsumos);
		modelo.addAttribute("movimientos", listamovimientos);

		modelo.addAttribute("Inventario", inventarioServicio.obtenerInventarioPorId(ID_Inventario));
		return "editar_inventario";
	}

	@PostMapping("/Consultar/{ID_Inventario}")
	public String updateInventario(@PathVariable Long ID_Inventario, @ModelAttribute("Inventario") Inventario inventario, Model modelo) {
		Inventario inventarioExistente = inventarioServicio.obtenerInventarioPorId(ID_Inventario);
		inventarioExistente.setID_Inventario(ID_Inventario);
		inventarioExistente.setInsumo(inventario.getInsumo());
		inventarioExistente.setMovimiento(inventario.getMovimiento());
		inventarioExistente.setCantidad(inventario.getCantidad());
		inventarioExistente.setFecha(inventario.getFecha());

		inventarioServicio.updateInventario(inventarioExistente);
		return "redirect:/Solware2/home/Consultar";
	}

	@GetMapping("/Consultar/{ID_Inventario}")
	public String deleteInventario(@PathVariable Long ID_Inventario) {

		inventarioServicio.delete(ID_Inventario);
		return "redirect:/Solware2/home/Consultar";

	}

}
