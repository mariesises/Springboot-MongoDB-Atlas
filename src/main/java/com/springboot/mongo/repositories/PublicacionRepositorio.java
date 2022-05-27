package com.springboot.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mongo.entidades.Publicacion;

@Repository
public interface PublicacionRepositorio extends MongoRepository<Publicacion,String>{
	
	
}
