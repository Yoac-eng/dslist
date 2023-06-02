package com.yoacspring.dslist.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yoacspring.dslist.dto.GameDTO;
import com.yoacspring.dslist.dto.GameMinDTO;
import com.yoacspring.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<GameDTO> findById(@PathVariable Long id){
		try {
			GameDTO result = gameService.findById(id);			
			return ResponseEntity.ok(result);
		}
		catch(NoSuchElementException e) {
	        return ResponseEntity.notFound().build();
		}
	}
}
