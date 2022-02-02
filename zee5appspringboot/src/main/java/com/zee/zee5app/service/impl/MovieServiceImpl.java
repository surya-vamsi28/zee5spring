package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.MovieService;
@Component
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	private MovieServiceImpl() {
		
	}

	
	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub
Movie movie2 =  movieRepository.save(movie);
		
		if(movie2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}

	}

	@Override
	public String updateMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.findById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		// TODO Auto-generated method stub
		List<Movie> movie1 = movieRepository.findAll();
		Movie[] array = new Movie[movie1.size()];
		return movie1.toArray(array);

	}

	@Override
	public Optional<List<Movie>> getAllMovieDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(movieRepository.findAll());
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Movie> optional;
		
			optional = this.getMovieById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				movieRepository.deleteById(id);
				return "Success";
			}
		

	

	}

}

