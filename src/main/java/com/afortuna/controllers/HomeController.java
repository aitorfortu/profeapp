package com.afortuna.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.afortuna.exceptions.DangerException;
import com.afortuna.repositories.RolRepository;

@Controller
public class HomeController {

	@Autowired
	private RolRepository rolRepository;

	// HOME
	@GetMapping("/")
	public String home(final ModelMap modelo) {
		modelo.put("view", "home/index");
		return "_t/frame";
	}

	// REGISTRO
	@GetMapping("/registro")
	public String registroGet(final ModelMap m) throws DangerException {
		m.put("view", "home/registro");
		return "_t/frame";
	}

	@PostMapping("/registro")
	public String registroPost(@RequestParam("tipoEntidad") final String tipoEntidad, final ModelMap m)
			throws DangerException {
		String link = "";
		if (tipoEntidad.equals("Alumno")) {
			link = "alumno/c";
		} else if (tipoEntidad.equals("Profesor")) {
			link = "profesor/c";
		}
		m.put("roles", rolRepository.findAll());
		m.put("view", link);
		return "redirect:" + link;
	}
}
