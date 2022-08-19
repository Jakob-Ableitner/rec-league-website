package com.jakobableitner.springboot.recLeague.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jakobableitner.springboot.recLeague.entity.Game;
import com.jakobableitner.springboot.recLeague.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	private GameRepository gameRepository;
	
	
	public GameServiceImpl(GameRepository theGameRepository) {
		gameRepository = theGameRepository;
	}
	
	@Override
	public List<Game> findAll() {
		return gameRepository.findAllByOrderByDateAsc();
	}

	@Override
	public Game findById(int theId) {
		Optional<Game> result = gameRepository.findById(theId);
		
		Game theGame = null;
		
		if (result.isPresent()) {
			theGame = result.get();
		}
		else {
			// we didn't find the game
			throw new RuntimeException("Did not find game id - " + theId);
		}
	
		return theGame;
	}

	@Override
	public void save(Game theGame) {
		gameRepository.save(theGame);
	}

	@Override
	public void deleteById(int theId) {
		gameRepository.deleteById(theId);
	}

}






