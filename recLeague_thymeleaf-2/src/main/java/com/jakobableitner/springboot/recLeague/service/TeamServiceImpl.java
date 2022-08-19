package com.jakobableitner.springboot.recLeague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jakobableitner.springboot.recLeague.entity.Team;
import com.jakobableitner.springboot.recLeague.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {
private TeamRepository teamRepository;
	
	
	public TeamServiceImpl(TeamRepository theTeamRepository) {
		teamRepository = theTeamRepository;
	}
	
	@Override
	public List<Team> findAll() {
		return teamRepository.findAllByOrderByWinsDesc();
	}

	@Override
	public Team findById(int theId) {
		Optional<Team> result = teamRepository.findById(theId);
		
		Team theTeam = null;
		
		if (result.isPresent()) {
			theTeam = result.get();
		}
		else {
			// we didn't find the game
			throw new RuntimeException("Did not find team id - " + theId);
		}
	
		return theTeam;
	}

	@Override
	public void save(Team theTeam) {
		teamRepository.save(theTeam);
	}

	@Override
	public void deleteById(int theId) {
		teamRepository.deleteById(theId);
	}
}
