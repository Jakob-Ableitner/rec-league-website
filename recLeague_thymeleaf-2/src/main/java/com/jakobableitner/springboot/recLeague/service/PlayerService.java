package com.jakobableitner.springboot.recLeague.service;

import java.util.List;

import com.jakobableitner.springboot.recLeague.entity.Player;

public interface PlayerService {

	public List<Player> findAll();
	
	public Player findById(int theId);
	
	public void save(Player thePlayer);
	
	public void deleteById(int theId);
	
}