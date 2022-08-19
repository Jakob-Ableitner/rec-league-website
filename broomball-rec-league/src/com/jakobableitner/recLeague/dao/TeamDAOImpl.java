package com.jakobableitner.recLeague.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;

@Repository
public class TeamDAOImpl implements TeamDAO{

	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
	
	@Override
	public List<Team> getTeams() {

		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Team> theQuery = currentSession.createQuery("from Team order by wins desc", Team.class);
		
		// execute query and get result list
				List<Team> teams = theQuery.getResultList();
						
				// return the results		
				return teams;
	}

	@Override
	public void saveTeam(Team theTeam) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTeam);
		
	}

	@Override
	public Team getTeam(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Team.class, theId);
	}

	@Override
	public void deleteTeam(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Team theTeam = currentSession.get(Team.class, theId);
		
		currentSession.delete(theTeam);
		
	}
	
	@Override
	public void clearTeamPlayers(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//get the team 
		Team team = currentSession.get(Team.class, theId);
		
		//get the teams players
		Set<Player> players = team.getPlayers();
		
		//loop through set and set each players team to null
		for (Player player : players) {
			player.setTeam(null);
			currentSession.update(player);
		}
	}

	

}
