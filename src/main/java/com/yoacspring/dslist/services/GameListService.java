package com.yoacspring.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoacspring.dslist.dto.GameListDTO;
import com.yoacspring.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListRepository.findAll().stream().map(x -> new GameListDTO(x)).toList();
		return result;
	}
}
