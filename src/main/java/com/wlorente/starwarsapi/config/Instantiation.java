package com.wlorente.starwarsapi.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.wlorente.starwarsapi.domain.Planeta;
import com.wlorente.starwarsapi.repository.PlanetaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PlanetaRepository userReposiroty;

	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		
		Planeta terra = new Planeta(null, "Planeta Terra", "Tropical","Montanhoso",25);
		
		userReposiroty.saveAll(Arrays.asList(terra));

		userReposiroty.save(terra);
	}

}
