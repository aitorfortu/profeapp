package com.afortuna.controllers;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.afortuna.domains.Entidad;
import com.afortuna.domains.Profesor;
import com.afortuna.domains.Rol;
import com.afortuna.exceptions.DangerException;
import com.afortuna.helpers.PRG;
import com.afortuna.repositories.ProfesorRepository;
import com.afortuna.repositories.RolRepository;

@Controller
@RequestMapping("profesor")
public class ProfesorController {

	@Autowired
	private ProfesorRepository profesorRepository;
	@Autowired
	private RolRepository rolRepository;

	@GetMapping("c")
	public String profesorCGet(final ModelMap m) {
		m.put("view", "profesor/c");
		m.put("roles", rolRepository.findAll());
		return "_t/frame";
	}

	@PostMapping("c")
	public String profesorCPost(@RequestParam("nombre") final String nombre,
			@RequestParam("apellidos") final String apellidos, @RequestParam("email") final String email,
			@RequestParam("contrasena") final String contrasena, @RequestParam("idRol") final Long idRol,
			@RequestParam("saldo") final String saldo, final HttpSession s) throws DangerException, ParseException {
		if (nombre == "" || apellidos == "" || email == "" || contrasena == "" || saldo == "") {
			PRG.error("Ningún campo puede quedar vacío", "/profesor/r");
		} else {
			final float fSaldo = Float.parseFloat(saldo);
			final Rol rol = rolRepository.getOne(idRol);
			final Profesor pr = new Profesor(nombre, apellidos, email, new BCryptPasswordEncoder().encode(contrasena),
					rol, fSaldo);
			final String rolActual = s.getAttribute("user") != null
					? ((Entidad) s.getAttribute("user")).getRol().getNombre()
					: "anon";
			if (rolActual == "User") {
				PRG.error("No puede estar logueado para realizar esta operación", "/");
			}
			try {
				profesorRepository.save(pr);
			} catch (final Exception e) {
				PRG.error("no puede haber usuarios iguales");
			}
		}

		return "redirect:/";
	}

}
