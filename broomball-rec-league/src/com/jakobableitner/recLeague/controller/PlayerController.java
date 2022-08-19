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

import com.jakobableitner.recLeague.dao.PlayerDAO;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;
import com.jakobableitner.recLeague.service.WebService;


@Controller
@RequestMapping("/player")
public class PlayerController {
	
	// need to inject the player service
		@Autowired
		private WebService webService;
	
	@GetMapping("/list")
	public String listPlayers(Model theModel) {
		
		// get players from the service
		List<Player> thePlayers = webService.getPlayers();
		
				
		// add the players to the model
		theModel.addAttribute("players", thePlayers);
		
		return "list-players";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Player thePlayer = new Player();
		
		theModel.addAttribute("player", thePlayer);
		
		List<Team> theTeams = webService.getTeams();
		
		theModel.addAttribute("teams", theTeams);
		
		return "player-form";
	}
	
	@PostMapping("/savePlayer")
	public String savePlayer(@ModelAttribute("player") Player thePlayer) {
		
		//save the player using our service
		webService.savePlayer(thePlayer);
		
		return "redirect:/player/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("playerId") int theId,
									Model theModel) 
    {
		
		// get the customer from our service
		Player thePlayer = webService.getPlayer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("player", thePlayer);
		
		List<Team> theTeams = webService.getTeams();
		
		theModel.addAttribute("teams", theTeams);
		
		// send over to our form		
		return "player-form";
	}
	
	@GetMapping("/deletePlayer")
	public String deletePlayer (@RequestParam("playerId") int theId) {
		//delete the player
		webService.deletePlayer(theId);
		
		return "redirect:/player/listPlayers";
	}
	
}




