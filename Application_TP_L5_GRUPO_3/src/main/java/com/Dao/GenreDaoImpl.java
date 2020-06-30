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

	public Genre getGenre(Integer id) {
		return (Genre) sHand.get(Genre.class, id);
	}

}
