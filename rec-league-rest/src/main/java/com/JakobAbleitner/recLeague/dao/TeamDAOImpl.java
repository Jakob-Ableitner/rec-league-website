package com.JakobAbleitner.recLeague.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JakobAbleitner.recLeague.entity.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Team> getTeams() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Team> theQuery = 
				currentSession.createQuery("from Team order by wins desc",
											Team.class);
		
		// execute query and get result list
		List<Team> teams = theQuery.getResultList();
				
		// return the results		
		return teams;
	}

	@Override
	public void saveTeam(Team theTeam) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the team ... finally LOL
		currentSession.saveOrUpdate(theTeam);
		
	}

	@Override
	public Team getTeam(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Team theTeam = currentSession.get(Team.class, theId);
		
		return theTeam;
	}

	@Override
	public void deleteTeam(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Team where id=:teamId");
		theQuery.setParameter("teamId", theId);
		
		theQuery.executeUpdate();		
	}

}











