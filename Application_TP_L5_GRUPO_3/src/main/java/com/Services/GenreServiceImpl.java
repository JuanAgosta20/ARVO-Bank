package com.Services;

import java.util.ArrayList;

import com.Dao.GenreDao;
import com.Model.BeanFactory;
import com.Model.Genre;

public class GenreServiceImpl implements GenreService {
	
	GenreDao gd;
	
	public GenreServiceImpl(GenreDao gdao) {
		gd = gdao;
	}
	
	public ArrayList<Genre> getAllGenres() {
		return gd.getAllGenres();
	}

	public Genre getGenre(Integer id) {
	public Genre getGenre(int id) {
		return gd.getGenre(id);
	}

}
