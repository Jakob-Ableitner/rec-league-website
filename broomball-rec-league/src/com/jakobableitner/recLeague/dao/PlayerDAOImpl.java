package com.jakobableitner.recLeague.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jakobableitner.recLeague.entity.Player;



@Repository
public class PlayerDAOImpl implements PlayerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Player> getPlayers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Player> theQuery = 
				currentSession.createQuery("from Player order by lastName", Player.class);
		
		// execute query and get result list
		List<Player> players = theQuery.getResultList();
				
		// return the results		
		return players;
	}
	
	@Override
	public void savePlayer(Player thePlayer) {
		//get current hibernate session
		Session currentSession= sessionFactory.getCurrentSession();
		
		//save the player 
		currentSession.saveOrUpdate(thePlayer);
	}
	
	@Override
	public Player getPlayer(int theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Player thePlayer = currentSession.get(Player.class, theId);
		
		return thePlayer;
	}
	
	@Override
	public void deletePlayer(int theId) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete object with primary key
//		Query theQuery =
//				currentSession.createQuery("delete from Player where id=:playerId");
//		theQuery.setParameter("playerId", theId);
//		
//		theQuery.executeUpdate();
		
		Player thePlayer = currentSession.get(Player.class, theId);
		currentSession.delete(thePlayer);
	}

}






