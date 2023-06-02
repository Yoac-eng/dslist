package com.yoacspring.dslist.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoacspring.dslist.dto.GameDTO;
import com.yoacspring.dslist.dto.GameMinDTO;
import com.yoacspring.dslist.entities.Game;
import com.yoacspring.dslist.projections.GameMinProjection;
import com.yoacspring.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	
	// Injeção de dependência de GameRepository
	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
	
	// FindById retorna um optional, permitindo que tratemos a excecao melhor mas por enquanto é isso
	@Transactional(readOnly = true)
	public GameDTO findById(Long id){
		Game result = gameRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Game not found"));

		return new GameDTO(result);
	}
	
	// Buscar jogos por lista
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
