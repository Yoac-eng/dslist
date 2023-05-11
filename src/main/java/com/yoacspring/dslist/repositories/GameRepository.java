package com.yoacspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoacspring.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

	
}
