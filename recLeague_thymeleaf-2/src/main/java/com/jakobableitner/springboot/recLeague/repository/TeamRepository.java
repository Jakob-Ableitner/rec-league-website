package com.jakobableitner.springboot.recLeague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakobableitner.springboot.recLeague.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

	public List<Team> findAllByOrderByWinsDesc();
	
}
