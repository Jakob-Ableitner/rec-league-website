package com.jakobableitner.springboot.recLeague.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="location")
	private String location;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="team1_score")
	private int team1Score;
	
	@Column(name="team2_score")
	private int team2Score;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="team1_id", nullable = false)
	private Team team1;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="team2_id", nullable = false)
	private Team team2;
	
	@Column(name="final")
	private boolean gFinal;

	
	
	public Game(int id, String location, Date date, int team1Score, int team2Score, Team team1, Team team2,
			boolean gFinal) {
		super();
		this.id = id;
		this.location = location;
		this.date = date;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
		this.team1 = team1;
		this.team2 = team2;
		this.gFinal = gFinal;
	}

	public Game() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public boolean isgFinal() {
		return gFinal;
	}

	public void setgFinal(boolean gFinal) {
		this.gFinal = gFinal;
	}

	
	

	
	
	
	

}
