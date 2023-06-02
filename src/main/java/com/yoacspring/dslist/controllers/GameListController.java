package com.yoacspring.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoacspring.dslist.dto.GameListDTO;
import com.yoacspring.dslist.dto.GameMinDTO;
import com.yoacspring.dslist.services.GameListService;
import com.yoacspring.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public ResponseEntity<List<GameListDTO>>  findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return ResponseEntity.ok(result);
	}
	
	// Esse endpoint ainda não tem tratamento para erro, apenas retorna a lista, recebendo parametro valido ou nao
	@GetMapping("/{listId}/games")
	public List<GameMinDTO> findGameByListId(@PathVariable Long listId){
			List<GameMinDTO> result = gameService.findByList(listId);
			return result;
	}
}
