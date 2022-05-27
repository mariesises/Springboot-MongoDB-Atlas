package com.springboot.mongo.services;

import java.util.List;

import com.springboot.mongo.controller.register.PublicacionDTO;
import com.springboot.mongo.entidades.Publicacion;

public interface PublicacionService {

	public Publicacion addPublicacion(PublicacionDTO publicacionDTO);
	public List<Publicacion> listarPublicaciones();
}
