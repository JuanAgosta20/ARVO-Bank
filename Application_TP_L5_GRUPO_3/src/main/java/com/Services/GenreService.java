package com.Services;

import java.util.ArrayList;

import com.Model.Genre;

public interface GenreService {
	public ArrayList<Genre> getAllGenres();
	public Genre getGenre(Integer id);
	public Genre getGenre(int id);

}
