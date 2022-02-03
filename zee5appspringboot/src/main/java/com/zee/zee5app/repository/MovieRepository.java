package com.zee.zee5app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movie;
@Component
public interface MovieRepository extends JpaRepository<Movie, String> {
//	Boolean existsByMovie_name(String movie_name);
	// retrieve details based on movieName and language
	// boolean results ===> exits
	//findby ===> 
//	Optional<Movie> findByMovie_nameAndMovie_language(String movie_name,String movie_language);
	
//	find a movie based on title/moviename and release_date , find a movie details by title.moviename
//	find the list of movies based on cast name
//	Optional<Movie> findByMovie_name(String movie_name);
//	Optional<Movie> findByMovie_nameAndMovie_Release_Date(String movie_name,String movie_Release_Date);
//	Optional<List<Movie>> findByMovie_cast(String movie_cast);
}
