package com.yoacspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoacspring.dslist.dto.GameMinDTO;
import com.yoacspring.dslist.entities.Game;
import com.yoacspring.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	
	// Injeção de dependência de GameRepository
	@Autowired
	private GameRepository gameRepository;

	public List<GameMinDTO> findAll(){
		// Método findAll padrão do jpa que retorna uma lista das entidades game
		List<Game> result = gameRepository.findAll();
		// Lambda pra transformar a lista de games em lista de gamesDTO
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}
}
