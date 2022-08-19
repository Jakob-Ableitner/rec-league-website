package com.jakobableitner.springboot.recLeague.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakobableitner.springboot.recLeague.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer>{
	public List<Player> findAllByOrderByLastName();
}
