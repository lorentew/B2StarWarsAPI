package com.wlorente.starwarsapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wlorente.starwarsapi.domain.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	//Planeta searchNome(String text);

}
