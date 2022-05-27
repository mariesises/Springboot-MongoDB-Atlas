package com.springboot.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springboot.mongo.entidades.Publicacion;
import com.springboot.mongo.repositories.PublicacionRepositorio;

@EnableMongoRepositories
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BearApplication implements CommandLineRunner {

	@Autowired
	PublicacionRepositorio publicRepo;

	public static void main(String[] args) {
		SpringApplication.run(BearApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------CREATE PUBLICITY ITEMS-------------------------------\n");

		//createGroceryItems();

	}

	void createGroceryItems() {
		System.out.println("Data creation started...");

		publicRepo.save(new Publicacion(null, "Pruebas", "snacks"));
		publicRepo.save(new Publicacion(null, "Mas pruebas", "snacks"));
		publicRepo.save(new Publicacion(null, "Vivan las pruebas", "snacks"));

		System.out.println("Data creation complete...");
	}

}
/*
 * SpringApplication.run(BearApplication.class, args);
 * 
 * ConnectionString connectionString = new ConnectionString(
 * "mongodb+srv://admin:admin@cluster0.xbm5p.mongodb.net/BearSN?retryWrites=true&w=majority"
 * ); MongoClientSettings settings = MongoClientSettings.builder()
 * .applyConnectionString(connectionString) .serverApi(ServerApi.builder()
 * .version(ServerApiVersion.V1) .build()) .build(); MongoClient mongoClient =
 * MongoClients.create(settings); MongoDatabase database =
 * mongoClient.getDatabase("BearSN");
 */
