package com.zee.zee5app.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.utils.DBUtils;
@Component
public class MovieRepositoryImpl implements MovieRepository {
	static private DBUtils dbUtils = null;
public MovieRepositoryImpl() throws IOException{
	DBUtils dbUtils = DBUtils.getInstance();	
	}
	
	
	private Set<Movie> set = new LinkedHashSet<>();

	@Override
	public String addMovie(Movie movie) {
		Connection connection = dbUtils.getConnection();
		String insertQuery = "insert into movie" + "(movie_id,movie_name,movie_cast,movie_length,movie_release_date,movie_trailer,movie_language,movie_agelimit,movie_genre)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement prepStatement = connection.prepareStatement(insertQuery);
			prepStatement.setString(1,movie.getMovie_id());
			prepStatement.setString(2,movie.getMovie_name());
			prepStatement.setString(3,movie.getMovie_cast());
			prepStatement.setInt(4,movie.getMovie_length());
			prepStatement.setString(5,movie.getMovie_Release_Date());
			prepStatement.setString(6,movie.getMovie_trailer());
			prepStatement.setString(7,movie.getMovie_language());
			prepStatement.setInt(8,movie.getMovie_agelimit());
			prepStatement.setString(9,movie.getMovie_genre());
			int result = prepStatement.executeUpdate();
			if(result > 0) {
				connection.commit();
				return "Success";
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(connection);
		}
		
		return "fail";
	}

	

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from movie where movieid=?";
		connection = dbUtils.getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
			Movie movie = new Movie();
			movie.setMovie_id(resultset.getString("movie_id"));
			movie.setMovie_name(resultset.getString("movie_name"));
			movie.setMovie_cast(resultset.getString("movie_cast"));
			movie.setMovie_length(resultset.getInt("movie_length"));
			movie.setMovie_Release_Date(resultset.getString("movie_release_date"));
			movie.setMovie_trailer(resultset.getString("movie_trailer"));
			movie.setMovie_language(resultset.getString("movie_language"));
			movie.setMovie_agelimit(resultset.getInt("movie_agelimit"));
			movie.setMovie_genre(resultset.getString("movie_genre"));
			return Optional.of(movie);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		return null;
	}
	
	
	
	
	

	@Override
	public Movie[] getAllMovies() {
Optional<List<Movie>> optional = getAllMovieDetails();
		
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Movie> list = optional.get();
			Movie[] movie = new Movie[list.size()];
			return list.toArray(movie);
		}

	}

	
	
	
	
	@Override
	public Optional<List<Movie>> getAllMovieDetails(){
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from movie";
		connection = dbUtils.getConnection();
		List<Movie> arraylist = new ArrayList<>(); 
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
			
				Movie movie = new Movie();
				movie.setMovie_id(resultset.getString("movie_id"));
				movie.setMovie_name(resultset.getString("movie_name"));
				movie.setMovie_cast(resultset.getString("movie_cast"));
				movie.setMovie_length(resultset.getInt("movie_length"));
				movie.setMovie_Release_Date(resultset.getString("movie_release_date"));
				movie.setMovie_trailer(resultset.getString("movie_trailer"));
				movie.setMovie_language(resultset.getString("movie_language"));
				movie.setMovie_agelimit(resultset.getInt("movie_agelimit"));
				movie.setMovie_genre(resultset.getString("movie_genre"));
				
				arraylist.add(movie);
				
			}
			return Optional.ofNullable(arraylist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.empty();
	}
	
	
	
	
	
	

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbUtils.getConnection();
		String deleteStatement = "delete from movie where movie_id = ?";
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			int result = preparedStatement.executeUpdate();
			if(result > 0 ) {
				connection.commit();
				return "success";
				
			}
			else {
				connection.rollback();
				return "fail";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtils.closeConnection(connection);
		}
		return "success";
	}
	
	
	
	
	@Override
	public String updateMovie(String id, Movie movie) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbUtils.getConnection();
		String updateStatement = "update movie SET (movie_id=?,movie_name=?,movie_cast=?,movie_length=?,movie_release_date=?,movie_trailer=?,movie_language=?,movie_agelimit=?,movie_genre=? where movie_id = ?" ;
		
		PreparedStatement preparedStatement = null;
		
		try {
			PreparedStatement prepStatement = connection.prepareStatement(updateStatement);
			prepStatement.setString(1,movie.getMovie_id());
			prepStatement.setString(2,movie.getMovie_name());
			prepStatement.setString(3,movie.getMovie_cast());
			prepStatement.setInt(4,movie.getMovie_length());
			prepStatement.setString(5,movie.getMovie_Release_Date());
			prepStatement.setString(6,movie.getMovie_trailer());
			prepStatement.setString(7,movie.getMovie_language());
			prepStatement.setInt(8,movie.getMovie_agelimit());
			prepStatement.setString(9,movie.getMovie_genre());
			prepStatement.setString(10, id);
			int result = prepStatement.executeUpdate();
			if (result > 0) {
				connection.commit();
				return "success";

			} else {
				connection.rollback();
				return "fail";
			}

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return "fail";
			
		
		

}
}

