package com.JakobAbleitner.recLeague.service;

import java.util.List;

import com.JakobAbleitner.recLeague.entity.Team;

public interface TeamService {

	public List<Team> getTeams();

	public void saveTeam(Team theCustomer);

	public Team getTeam(int theId);

	public void deleteTeam(int theId);
	
}
