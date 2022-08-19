package com.jakobableitner.recLeague.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jakobableitner.recLeague.entity.Game;
import com.jakobableitner.recLeague.entity.Player;
import com.jakobableitner.recLeague.entity.Team;

@Repository
public class GameDAOImpl implements GameDAO{
	
	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Game> getGames() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query
			Query<Game> theQuery = 
					currentSession.createQuery("from Game order by date", Game.class);
			
			// execute query and get result list
			List<Game> games = theQuery.getResultList();
					
			// return the results		
			return games;
		}

		@Override
		public void saveGame(Game theGame) {

			Session currentSession = sessionFactory.getCurrentSession();
			
			//save the game 
			currentSession.saveOrUpdate(theGame);
			
		}

		@Override
		public Game getGame(int theId) {

			//get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			//now retrieve/read from database using the primary key
			Game theGame = currentSession.get(Game.class, theId);
			
			return theGame;
		}

		@Override
		public void deleteGame(int theId) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			
			Game theGame = currentSession.get(Game.class, theId);
			currentSession.delete(theGame);
			
		}
}
