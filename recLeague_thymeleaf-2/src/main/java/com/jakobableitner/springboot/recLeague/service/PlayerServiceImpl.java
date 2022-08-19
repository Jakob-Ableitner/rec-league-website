package com.jakobableitner.springboot.recLeague.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jakobableitner.springboot.recLeague.entity.Player;
import com.jakobableitner.springboot.recLeague.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	private PlayerRepository playerRepository;
	
	
	public PlayerServiceImpl(PlayerRepository thePlayerRepository) {
		playerRepository = thePlayerRepository;
	}
	
	@Override
	public List<Player> findAll() {
		return playerRepository.findAllByOrderByLastName();
	}

	@Override
	public Player findById(int theId) {
		Optional<Player> result = playerRepository.findById(theId);
		
		Player thePlayer = null;
		
		if (result.isPresent()) {
			thePlayer = result.get();
		}
		else {
			// we didn't find the player
			throw new RuntimeException("Did not find player id - " + theId);
		}
	
		return thePlayer;
	}

	@Override
	public void save(Player thePlayer) {
		playerRepository.save(thePlayer);
	}

	@Override
	public void deleteById(int theId) {
		playerRepository.deleteById(theId);
	}

}
