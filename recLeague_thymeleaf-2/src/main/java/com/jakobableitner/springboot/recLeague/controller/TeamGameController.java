package com.jakobableitner.springboot.recLeague.controller;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jakobableitner.springboot.recLeague.entity.Game;
import com.jakobableitner.springboot.recLeague.entity.Team;
import com.jakobableitner.springboot.recLeague.service.GameService;
import com.jakobableitner.springboot.recLeague.service.TeamService;


@Controller
@RequestMapping("/admin/teamgame")
public class TeamGameController {
	
	private GameService gameService;
	private TeamService teamService;
	
	public TeamGameController(GameService theGameService, TeamService theTeamService) {
		gameService = theGameService;
		teamService = theTeamService;
	}
		
		@GetMapping("/list")
		public String listGames(Model theModel) {
			
			// get games from db
			List<Game> theGames = gameService.findAll();
			
			// add to the spring model
			theModel.addAttribute("games", theGames);
			
			// get teams from db
			List<Team> theTeams = teamService.findAll();
			
			//use to format winPct
			DecimalFormat df = new DecimalFormat("0.000");
			
			
			for (Team team : theTeams) {
				
				double winPct =((double)team.getWins() /(team.getWins() + team.getLosses()));
				String formattedPct = df.format(winPct);
				
				team.setWinPct(formattedPct);
			}
			// add to the spring model
			theModel.addAttribute("teams", theTeams);
			
			return "games/standings-schedule";
		}
}
