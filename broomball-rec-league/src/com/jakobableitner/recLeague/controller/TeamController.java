package com.jakobableitner.recLeague.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;
import com.jakobableitner.recLeague.service.WebService;


@Controller
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private WebService webService;
	
	@GetMapping("/standings")
	public String standings(Model theModel) {
		
		// get teams from the service
		List<Team> theTeams = webService.getTeams();
		
				
		// add the teams to the model
		theModel.addAttribute("teams", theTeams);
		
		// get games from the service
		List<Game> theGames = webService.getGames();
					
							
					// add the games to the model
		theModel.addAttribute("games", theGames);
					
		return "standings-schedule";
		
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Team theTeam = new Team();
		
		theModel.addAttribute("team", theTeam);
		
		return "team-form";
	}
	
	@PostMapping("/saveTeam")
	public String saveTeam(@ModelAttribute("team") Team theTeam) {
		
		//save the player using our service
		webService.saveTeam(theTeam);
		
		return "redirect:/team/standings";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("teamId") int theId,
									Model theModel) 
    {
		
		// get the customer from our service
		Team theTeam = webService.getTeam(theId);	
		
		// set team as a model attribute to pre-populate the form
		theModel.addAttribute("team", theTeam);
		
		// send over to our form		
		return "team-form";
	}
	
	@GetMapping("/deleteTeam")
	public String deleteTeam (@RequestParam("teamId") int theId) {
		
		//set teams players to null 
		webService.clearTeamPlayers(theId);
		
		//delete the team
		webService.deleteTeam(theId);
		
		return "redirect:/team/standings";
	}
	
	
}
