package com.springboot.mongo.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.springboot.mongo.controller.register.PublicacionDTO;
import com.springboot.mongo.entidades.Publicacion;
import com.springboot.mongo.repositories.PublicacionRepositorio;

@Service
public class PublicacionServiceImpl implements PublicacionService {

	ConnectionString connectionString = new ConnectionString(
			"mongodb+srv://admin:admin@cluster0.xbm5p.mongodb.net/BearSN?retryWrites=true&w=majority");
	MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
			.serverApi(ServerApi.builder().version(ServerApiVersion.V1).build()).build();

	MongoClient mongoClient = MongoClients.create(settings);

	MongoDatabase database = mongoClient.getDatabase("BearSN");

	MongoCollection<Document> collection = database.getCollection("Publicacion");

	@Autowired(required = false)
	private PublicacionRepositorio publicacionRepositorio;

	public PublicacionServiceImpl(PublicacionRepositorio publicacionRepositorio) {
		super();
		this.publicacionRepositorio = publicacionRepositorio;
	}

	@Override
	public List<Publicacion> listarPublicaciones() {
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
			while (cursor.hasNext()) {
				System.out.println(cursor.next().toJson());
			}
		} finally {
			cursor.close();
		}
		FindIterable<Document> findIterable = collection.find();
		System.out.println(findIterable.toString());

		return publicacionRepositorio.findAll();
	}

	@Override
	public Publicacion addPublicacion(PublicacionDTO publicacionDTO) {
		Publicacion publicacion = new Publicacion(null, publicacionDTO.getTitulo(), publicacionDTO.getDescripcion());
		return publicacionRepositorio.save(publicacion);
	}
}
