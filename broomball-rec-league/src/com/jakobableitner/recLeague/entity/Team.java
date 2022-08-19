package com.jakobableitner.recLeague.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="team")
	private Set<Player> players = new HashSet<Player>();

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="team1")
	private Set<Game> games1 = new HashSet<Game>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="team2")
	private Set<Game> games2 = new HashSet<Game>();
	
	public Team() {
		super();
	}
	
	public Team(String teamName, int wins, int losses) {
		super();
		this.teamName = teamName;
		this.wins = wins;
		this.losses = losses;
	}



	public Team(int id, String teamName, int wins, int losses, Set<Player> players) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.wins = wins;
		this.losses = losses;
		this.players = players;
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

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Set<Game> getGames1() {
		return games1;
	}

	public void setGames1(Set<Game> games1) {
		this.games1 = games1;
	}
	
	public Set<Game> getGames2() {
		return games2;
	}

	public void setGames2(Set<Game> games2) {
		this.games2 = games2;
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", teamName=" + teamName + ", wins=" + wins + ", losses=" + losses + "]";
	}
	
	
}
