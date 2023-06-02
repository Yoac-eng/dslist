package com.yoacspring.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoacspring.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

	
}
