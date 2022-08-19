package com.jakobableitner.recLeague.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jakobableitner.recLeague.dao.GameDAO;
import com.jakobableitner.recLeague.dao.PlayerDAO;
import com.jakobableitner.recLeague.dao.TeamDAO;
import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;

@Service
public class WebServiceImpl implements WebService {
	
	@Autowired
	private PlayerDAO playerDAO;
	
	@Autowired
	private TeamDAO teamDAO;
	
	@Autowired
	private GameDAO gameDAO;
	
	@Override
	@Transactional
	public List<Player> getPlayers(){
		return playerDAO.getPlayers();
	}
	
	@Override
	@Transactional
	public void savePlayer(Player thePlayer) {
		playerDAO.savePlayer(thePlayer);
	}
	
	@Override
	@Transactional
	public Player getPlayer(int theId) {
		return playerDAO.getPlayer(theId);
	}
	
	@Override
	@Transactional
	public void deletePlayer(int theId) {
		playerDAO.deletePlayer(theId);
	}
	
	@Override
	@Transactional
	public List<Team> getTeams(){
		return teamDAO.getTeams();
	}
	
	@Override
	@Transactional
	public void saveTeam(Team theTeam) {
		teamDAO.saveTeam(theTeam);
	}
	
	@Override
	@Transactional
	public Team getTeam(int theId) {
		return teamDAO.getTeam(theId);
	}
	
	@Override
	@Transactional
	public void deleteTeam(int theId) {
		teamDAO.deleteTeam(theId);
	}
	
	@Override
	@Transactional
	public void clearTeamPlayers(int theId) {
		teamDAO.clearTeamPlayers(theId);
	}
	
	@Override
	@Transactional
	public List<Game> getGames(){
		return gameDAO.getGames();
	}

	@Override
	@Transactional
	public void saveGame(Game theGame) {
		gameDAO.saveGame(theGame);
		
	}

	@Override
	@Transactional
	public Game getGame(int theId) {
		return gameDAO.getGame(theId);
	}

	@Override
	@Transactional
	public void deleteGame(int theId) {
		gameDAO.deleteGame(theId);
	}
	
}
