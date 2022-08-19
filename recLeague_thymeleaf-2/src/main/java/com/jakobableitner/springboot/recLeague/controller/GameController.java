package com.jakobableitner.springboot.recLeague.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jakobableitner.springboot.recLeague.entity.Game;
import com.jakobableitner.springboot.recLeague.entity.Team;
import com.jakobableitner.springboot.recLeague.service.GameService;
import com.jakobableitner.springboot.recLeague.service.TeamService;

@Controller
@RequestMapping("/admin/games")
public class GameController {

	private GameService gameService;
	private TeamService teamService;
	
	public GameController(GameService theGameService, TeamService theTeamService) {
		gameService = theGameService;
		teamService = theTeamService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listGames(Model theModel) {
		
		// get games from db
		List<Game> theGames = gameService.findAll();
		
		// add to the spring model
		theModel.addAttribute("games", theGames);
		
		return "games/list-games";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Game theGame = new Game();
		
		theModel.addAttribute("game", theGame);
		
		//get list of teams to select from
		List<Team> theTeams = teamService.findAll();
		
		theModel.addAttribute("teams", theTeams);
		
		return "games/game-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("gameId") int theId,
									Model theModel) {
		
		// get the game from the service
		Game theGame = gameService.findById(theId);
		
		// set game as a model attribute to pre-populate the form
		theModel.addAttribute("game", theGame);
		
		//get list of teams to select from
		List<Team> theTeams = teamService.findAll();
		
		theModel.addAttribute("teams", theTeams);
		
		// send over to our form
		return "games/game-form";			
	}
	
	
	@PostMapping("/save")
	public String saveGame(@ModelAttribute("game") Game theGame) {
		
		// save the game
		gameService.save(theGame);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/teamgame/list";
	}
	
	@GetMapping("/deleteById")
	public String deleteById (@RequestParam("gameId") int theId) {
		

		gameService.deleteById(theId);
		
		return "redirect:/admin/teamgame/list";
	}
	
}












