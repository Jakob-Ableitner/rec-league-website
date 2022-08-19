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
import com.jakobableitner.springboot.recLeague.service.TeamService;


@Controller
@RequestMapping("/admin/teams")
public class TeamController {
private TeamService teamService;
	
	public TeamController(TeamService theTeamService) {
		teamService = theTeamService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listTeams(Model theModel) {
		
		// get employees from db
		List<Team> theTeams = teamService.findAll();
		
		// add to the spring model
		theModel.addAttribute("teams", theTeams);
		
		return "teams/list-teams";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Team theTeam = new Team();
		
		theModel.addAttribute("team", theTeam);
		
		return "teams/team-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("teamId") int theId,
									Model theModel) {
		
		// get the team from the service
		Team theTeam = teamService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("team", theTeam);
		
		// send over to our form
		return "teams/team-form";			
	}
	
	
	@PostMapping("/save")
	public String saveTeam(@ModelAttribute("team") Team theTeam) {
		
		// save the team
		teamService.save(theTeam);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/admin/teamgame/list";
	}
	
	@GetMapping("/deleteById")
	public String deleteById (@RequestParam("teamId") int theId) {
		

		teamService.deleteById(theId);
		
		return "redirect:/admin/teamgame/list";
	}
	
}
