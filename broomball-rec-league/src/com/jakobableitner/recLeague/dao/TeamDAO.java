package com.jakobableitner.recLeague.dao;

import java.util.List;

import com.jakobableitner.recLeague.entity.Team;

public interface TeamDAO {
	
	public List<Team> getTeams();
	
	public void saveTeam(Team theTeam);
	
	public Team getTeam(int theId);
	
	public void deleteTeam(int theId);
	
	public void clearTeamPlayers(int theId);
}
