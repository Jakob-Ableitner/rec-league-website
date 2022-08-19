package com.JakobAbleitner.recLeague.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team")
public class Team {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="team_name")
	private String teamName;
	
	@Column(name="wins")
	private int wins;
	
	@Column(name="losses")
	private int losses;
	
	public Team() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", wins=" + wins + ", losses=" + losses + "]";
	}

	
		
}





