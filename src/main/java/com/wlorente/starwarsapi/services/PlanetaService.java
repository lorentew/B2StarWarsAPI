package com.wlorente.starwarsapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlorente.starwarsapi.repository.PlanetaRepository;
import com.wlorente.starwarsapi.domain.Planeta;
import com.wlorente.starwarsapi.services.exceptions.ObjectNotFoundException;
import com.wlorente.starwarsapi.dto.PlanetaDTO;

@Service
public class PlanetaService {

	@Autowired
	private PlanetaRepository repo;
	
	public List<Planeta> findAll() {
		return repo.findAll();
	}

	public Planeta findById(String id) {
		Optional<Planeta> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	//public Planeta findByNome(String nome) {
	//	Optional<Planeta> obj = Optional.of(repo.searchNome(nome));
	//	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	//}

	public Planeta insert(Planeta obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Planeta fromDTO(PlanetaDTO objDto) {
		return new Planeta(objDto.getId(), objDto.getNome(), objDto.getClima(), objDto.getTerreno(), objDto.getQtde_aparicoes());
	}
}
