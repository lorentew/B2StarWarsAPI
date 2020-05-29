package com.wlorente.starwarsapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.wlorente.starwarsapi.domain.Planeta;
import com.wlorente.starwarsapi.dto.PlanetaDTO;
import com.wlorente.starwarsapi.services.PlanetaService;
import com.wlorente.starwarsapi.resources.util.URL;

@RestController
@RequestMapping(value="/planets")
public class PlanetaResource {
	
	@Autowired
	private PlanetaService service;
	
	@RequestMapping(method=RequestMethod.GET)
 	public ResponseEntity<List<PlanetaDTO>> findAll() {
		List<Planeta> list = service.findAll();
		List<PlanetaDTO> listDto = list.stream().map(x -> new PlanetaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
 	public ResponseEntity<PlanetaDTO> findById(@PathVariable String id) {
		Planeta obj = service.findById(id);
		return ResponseEntity.ok().body(new PlanetaDTO(obj));
	}
	
	@RequestMapping(value="/nome", method=RequestMethod.GET)
 	public ResponseEntity<List<Planeta>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		System.out.println("Consulta por nome "+ text);
		text = URL.decodeParam(text);
		List<Planeta> list = service.findByNome(text);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method=RequestMethod.POST)
 	public ResponseEntity<Void> insert(@RequestBody PlanetaDTO objDto) {
		Planeta obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
