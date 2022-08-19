package com.jakobableitner.springboot.recLeague.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jakobableitner.springboot.recLeague.entity.Player;
import com.jakobableitner.springboot.recLeague.entity.Team;
import com.jakobableitner.springboot.recLeague.service.PlayerService;
import com.jakobableitner.springboot.recLeague.service.TeamService;

@Controller
@RequestMapping("/admin/players")
public class PlayerController {

	private PlayerService playerService;
	private TeamService teamService;
	
	public PlayerController(PlayerService thePlayerService, TeamService theTeamService) {
		playerService = thePlayerService;
		teamService = theTeamService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listPlayers(Model theModel) {
		
		// get players from db
		List<Player> thePlayers = playerService.findAll();
		
		// add to the spring model
		theModel.addAttribute("players", thePlayers);
		
		return "players/list-players";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Player thePlayer = new Player();
		
		theModel.addAttribute("player", thePlayer);
		
		//get list of teams to select from
		List<Team> theTeams = teamService.findAll();
		
		theModel.addAttribute("teams", theTeams);
		
		return "players/player-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId,
									Model theModel) {
		
		// get the player from the service
		Player thePlayer = playerService.findById(theId);
		
		// set game as a model attribute to pre-populate the form
		theModel.addAttribute("player", thePlayer);
		
		//get list of teams to select from
		List<Team> theTeams = teamService.findAll();
		
		theModel.addAttribute("teams", theTeams);
		
		// send over to our form
		return "players/player-form";			
	}
	
	
	@PostMapping("/save")
	public String savePlayer(@ModelAttribute("player") Player thePlayer) {
		
		// save the game
		playerService.save(thePlayer);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/players/list";
	}
	
	@GetMapping("/deleteById")
	public String deleteById (@RequestParam("playerId") int theId) {
		
		playerService.deleteById(theId);
		
		return "redirect:/admin/players/list";
	}
	
}
