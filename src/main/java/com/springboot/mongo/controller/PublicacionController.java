package com.springboot.mongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.mongo.controller.register.PublicacionDTO;
import com.springboot.mongo.services.PublicacionServiceImpl;

@Controller
@RequestMapping("/publicaciones")
public class PublicacionController {
	
	@Autowired
	private PublicacionServiceImpl publicacionServiceImpl;


	public PublicacionController(PublicacionServiceImpl publicacionServiceImpl) {
		super();
		this.publicacionServiceImpl = publicacionServiceImpl;
	}


	@ModelAttribute("publicacion")
	public PublicacionDTO retornarNuevaPublicacion() {
		return new PublicacionDTO();
	}

	
	public String mostrarFormularioDeRegistro() {
		return "publicaciones";
	}

	@PostMapping
	public String registrarPublicacion(@ModelAttribute("publicacion") PublicacionDTO publicacionDTO) {
		publicacionServiceImpl.addPublicacion(publicacionDTO);
		return "redirect:/publicaciones?exito";
	}

	@GetMapping
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("publicaciones", publicacionServiceImpl.listarPublicaciones());
		return "publicaciones";
	}
	
}
