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
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private WebService webService;
	
	@GetMapping("/schedule")
	public String scheudule(Model theModel) {
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
			Game theGame = new Game();
			
			theModel.addAttribute("game", theGame);
			
			List<Team> theTeams = webService.getTeams();
			
			theModel.addAttribute("teams", theTeams);
			
			return "game-form";
		}
		
		@PostMapping("/saveGame")
		public String saveGame(@ModelAttribute("game") Game theGame) {
			
			//save the player using our service
			webService.saveGame(theGame);
			
			return "redirect:/game/schedule";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("gameId") int theId,
										Model theModel) 
	    {
			
			// get the game from our service
			Game theGame = webService.getGame(theId);	
			
			// set game as a model attribute to pre-populate the form
			theModel.addAttribute("game", theGame);
			
			List<Team> theTeams = webService.getTeams();
			
			theModel.addAttribute("teams", theTeams);
			
			// send over to our form		
			return "game-form";
		}
		
		@GetMapping("/deleteGame")
		public String deleteGame (@RequestParam("gameId") int theId) {
			//delete the player
			webService.deleteGame(theId);
			
			return "redirect:/game/schedule";
		}
	
}
