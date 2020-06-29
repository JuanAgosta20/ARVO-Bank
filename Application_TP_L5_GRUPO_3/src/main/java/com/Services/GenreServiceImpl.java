package com.Services;

import java.util.ArrayList;

import com.Dao.GenreDao;
import com.Model.BeanFactory;
import com.Model.Genre;

public class GenreServiceImpl implements GenreService {

	BeanFactory bf = new BeanFactory();
	GenreDao gd = bf.createGenreDaoImpl();
	
	public ArrayList<Genre> getAllGenres() {
		return gd.getAllGenres();
	}

	public Genre getGenre(int id) {
		return gd.getGenre(id);
	}

}
