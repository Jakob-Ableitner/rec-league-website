package com.jakobableitner.springboot.recLeague.service;

import java.util.List;

import com.jakobableitner.springboot.recLeague.entity.Game;

public interface GameService {

	public List<Game> findAll();
	
	public Game findById(int theId);
	
	public void save(Game theGame);
	
	public void deleteById(int theId);
	
}
