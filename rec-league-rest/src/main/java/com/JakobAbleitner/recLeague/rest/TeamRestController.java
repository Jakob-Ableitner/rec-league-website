package com.JakobAbleitner.recLeague.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JakobAbleitner.recLeague.entity.Team;
import com.JakobAbleitner.recLeague.service.TeamService;

@RestController
@RequestMapping("/api")
public class TeamRestController {

	// autowire the TeamService
	@Autowired
	private TeamService teamService;
	
	// add mapping for GET /teams
	@GetMapping("/teams")
	public List<Team> getTeams() {
		
		return teamService.getTeams();
		
	}
	
	// add mapping for GET /teams/{teamId}
	
	@GetMapping("/teams/{teamId}")
	public Team getTeam(@PathVariable int teamId) {
		
		Team theTeam = teamService.getTeam(teamId);
		
		if (theTeam == null) {
			throw new TeamNotFoundException("Team id not found - " + teamId);
		}
		
		return theTeam;
	}

	// add mapping for POST /customers  - add new team
	
	@PostMapping("/teams")
	public Team addTeam(@RequestBody Team theTeam) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theTeam.setId(0);
		
		teamService.saveTeam(theTeam);
		
		return theTeam;
	}
	
		
	
}


















