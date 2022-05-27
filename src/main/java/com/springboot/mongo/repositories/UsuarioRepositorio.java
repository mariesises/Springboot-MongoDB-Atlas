package com.springboot.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends MongoRepository<Usuario, Long> {

	public Usuario findByEmail(String email);

}
