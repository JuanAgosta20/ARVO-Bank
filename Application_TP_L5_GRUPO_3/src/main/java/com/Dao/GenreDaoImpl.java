package com.Dao;

import java.util.ArrayList;

import org.hibernate.Session;

import com.Model.Genre;

public class GenreDaoImpl implements GenreDao {

	SessionHandler sHand = new SessionHandler();
	Session session;

	@SuppressWarnings("unchecked")
	public ArrayList<Genre> getAllGenres() {
		return (ArrayList<Genre>) sHand.getAllData(Genre.class);
	}

	public Genre getGenre(int id) {
		session = sHand.getSession();
		return (Genre)session.get(Genre.class, id);
	}

}
