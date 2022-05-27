package com.springboot.mongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.mongo.controller.register.PublicacionDTO;
import com.springboot.mongo.services.PublicacionServiceImpl;

@Controller
@RequestMapping("/ventanaModal")
public class PublicacionRegistroController {

	private PublicacionServiceImpl publicacionServiceImpl;

	public PublicacionRegistroController(PublicacionServiceImpl publicacionServiceImpl) {
		super();
		this.publicacionServiceImpl = publicacionServiceImpl;
	}

	@ModelAttribute("publicacion")
	public PublicacionDTO retornarNuevaPublicacion() {
		return new PublicacionDTO();
	}
	

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "ventanaModal";
	}

	@PostMapping
	public String registrarPublicacion(@ModelAttribute("publicacion") PublicacionDTO publicacionDTO) {
		publicacionServiceImpl.addPublicacion(publicacionDTO);
		return "redirect:/publicaciones?exito";
	}
	
}
