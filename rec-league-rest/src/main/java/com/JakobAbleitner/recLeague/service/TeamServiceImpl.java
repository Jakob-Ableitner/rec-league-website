package com.JakobAbleitner.recLeague.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JakobAbleitner.recLeague.dao.TeamDAO;
import com.JakobAbleitner.recLeague.entity.Team;

@Service
public class TeamServiceImpl implements TeamService {

	// need to inject team dao
	@Autowired
	private TeamDAO teamDAO;
	
	@Override
	@Transactional
	public List<Team> getTeams() {
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
}





