package com.jakobableitner.springboot.recLeague.service;

import java.util.List;

import com.jakobableitner.springboot.recLeague.entity.Team;

public interface TeamService {

	public List<Team> findAll();
	
	public Team findById(int theId);
	
	public void save(Team theTeam);
	
	public void deleteById(int theId);
	
}
