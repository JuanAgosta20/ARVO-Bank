package com.Dao;

import java.util.ArrayList;

import com.Model.Genre;

public class GenreDaoImpl implements GenreDao {

	SessionHandler sHand = new SessionHandler();

	@SuppressWarnings("unchecked")
	public ArrayList<Genre> getAllGenres() {
		return (ArrayList<Genre>) sHand.getAllData(Genre.class);
	}

}
