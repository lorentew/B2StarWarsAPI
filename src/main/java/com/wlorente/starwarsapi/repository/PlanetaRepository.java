package com.wlorente.starwarsapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wlorente.starwarsapi.domain.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String> {
	
	List<Planeta> findByNomeContainingIgnoreCase(String text);

}
