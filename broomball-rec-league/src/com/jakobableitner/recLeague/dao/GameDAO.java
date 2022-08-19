package com.jakobableitner.recLeague.dao;

import java.util.List;

import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;

public interface GameDAO {
	
	public List<Game> getGames();
	
	public void saveGame(Game theGame);
	
	public Game getGame(int theId);
	
	public void deleteGame(int theId);
}
