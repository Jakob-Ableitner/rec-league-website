package com.jakobableitner.springboot.recLeague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakobableitner.springboot.recLeague.entity.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

	public List<Game> findAllByOrderByDateAsc();
	
}
