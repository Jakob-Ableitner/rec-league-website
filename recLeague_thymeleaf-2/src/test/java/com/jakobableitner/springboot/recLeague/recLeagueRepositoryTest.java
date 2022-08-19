package com.jakobableitner.springboot.recLeague;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jakobableitner.springboot.recLeague.repository.GameRepository;

@SpringBootTest(classes = recLeagueThymeLeafApplication.class)
public class recLeagueRepositoryTest {
	
	@Autowired
	GameRepository gameRepository;	
	
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	
	@Test 
	void testGameRepositoryIsNull(){
		Assertions.assertNotNull(gameRepository);
	}
	
	@Test 
	void testFindGameById() {
		Assertions.assertEquals("Vikings", gameRepository.findById(12).get().getTeam1().getTeamName());
		Assertions.assertEquals("raiders", gameRepository.findById(12).get().getTeam2().getTeamName());
		try {
			Assertions.assertEquals(df.parse("11-08-2022"), gameRepository.findById(12).get().getDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
