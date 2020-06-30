package com.Dao;

import java.util.ArrayList;

import com.Model.Genre;

public interface GenreDao {

	public ArrayList<Genre> getAllGenres();

	public Genre getGenre(Integer id);

}
