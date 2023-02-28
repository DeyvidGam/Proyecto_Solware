package com.app.web.controlador;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroresControlador implements ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMessage", "Ha ocurrido un error.");
		modelAndView.setViewName("error500"); //nombre del archivo de la plantilla (template)
		return modelAndView;
	}

	public String getErrorPathh() {
		return "/error500";
	}

	@RequestMapping("/error404")
	public ModelAndView handle404Error(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errorMessage", "La página solicitada no se ha encontrado.");
		modelAndView.setViewName("Error404"); //nombre del archivo de la plantilla (template)
		return modelAndView;
	}


	public String getErrorPath() {
		return "/Error404";
	}

}

