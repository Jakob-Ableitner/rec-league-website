package com.jakobableitner.recLeague.service;

import java.util.List;

import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;

public interface WebService {
	
	public List<Player> getPlayers();
	
	public void savePlayer(Player thePlayer);
	
	public Player getPlayer(int theId);
	
	public void deletePlayer(int theId);
	
	public List<Team> getTeams();
	
	public void saveTeam(Team theTeam);
	
	public Team getTeam(int theId);
	
	public void deleteTeam(int theId);
	
	public void clearTeamPlayers(int theId);
	
	public List<Game> getGames();
	
	public void saveGame(Game theGame);
	
	public Game getGame(int theId);
	
	public void deleteGame(int theId);
}
