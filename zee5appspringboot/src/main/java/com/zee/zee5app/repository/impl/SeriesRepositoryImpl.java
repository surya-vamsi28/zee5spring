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

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.utils.DBUtils;
@Component
public class SeriesRepositoryImpl implements SeriesRepository {
	static private DBUtils dbutils = null;
public SeriesRepositoryImpl() throws IOException{
	dbutils = DBUtils.getInstance();
	}

	
	private TreeSet<Series> set = new TreeSet<>();

	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertQuery = "insert into series" + "(series_id,series_name,series_cast,series_length,series_releasedate,series_trailer,series_language,series_agelimit,series_genre)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		
			PreparedStatement prepStatement;
			try {
				prepStatement = connection.prepareStatement(insertQuery);
				prepStatement.setString(1,series.getSeries_id());
				prepStatement.setString(2,series.getSeries_name());
				prepStatement.setString(3,series.getSeries_cast());
				prepStatement.setInt(4,series.getSeries_length());
				prepStatement.setString(5,series.getSeries_release_date());
				prepStatement.setInt(6,series.getSeries_episodes());
				prepStatement.setString(7,series.getSeries_language());
				prepStatement.setInt(8,series.getSeries_agelimit());
				prepStatement.setString(9,series.getSeries_genre());
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
			dbutils.closeConnection(connection);
		}
		
		return "fail";
	}


	

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from series where series_id=?";
		connection = dbutils.getConnection();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			preparedStatement.setString(1, id);
			resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
			Series series = new Series();
			series.setSeries_id(resultset.getString("series_id"));
			series.setSeries_name(resultset.getString("series_name"));
			series.setSeries_cast(resultset.getString("series_cast"));
			series.setSeries_length(resultset.getInt("series_length"));
			series.setSeries_release_date(resultset.getString("series_releasedate"));
			series.setSeries_episodes(resultset.getInt("series_episodes"));
			series.setSeries_language(resultset.getString("series_language"));
			series.setSeries_agelimit(resultset.getInt("series_agelimit"));
			series.setSeries_genre(resultset.getString("series_genre"));
			return Optional.of(series);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutils.closeConnection(connection);
		}
		return null;
	}

	

	@Override
	public Series[] getAllSeriess() {
		// TODO Auto-generated method stub
Optional<List<Series>> optional = getAllSeriesDetails();
		
		if(optional.isEmpty()) {
			return null;
		}
		else {
			List<Series> list = optional.get();
			Series[] series = new Series[list.size()];
			return list.toArray(series);
		}

	}
	
	
	
	@Override
	public  Optional<List<Series>> getAllSeriesDetails(){
	Connection connection = null;
		ResultSet resultset = null;
		String selectStatement = "select * from series";
		connection = dbutils.getConnection();
		List<Series> arraylist = new ArrayList<>(); 
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(selectStatement);
			
			resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
			
				Series series = new Series();
				series.setSeries_id(resultset.getString("series_id"));
				series.setSeries_name(resultset.getString("series_name"));
				series.setSeries_cast(resultset.getString("series_cast"));
				series.setSeries_length(resultset.getInt("series_length"));
				series.setSeries_release_date(resultset.getString("series_releasedate"));
				series.setSeries_episodes(resultset.getInt("series_episodes"));
				series.setSeries_language(resultset.getString("series_language"));
				series.setSeries_agelimit(resultset.getInt("series_agelimit"));
				series.setSeries_genre(resultset.getString("series_genre"));
				
				arraylist.add(series);
				
			}
			return Optional.ofNullable(arraylist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbutils.closeConnection(connection);
		}
		return Optional.empty();
	}

	

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbutils.getConnection();
		String deleteStatement = "delete from series where series_id = ?";
		
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
			dbutils.closeConnection(connection);
		}
		return "success";

		
		
	}
	@Override
	public String updateSeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Connection connection = null;
		ResultSet resultset = null;
		
		connection = dbutils.getConnection();
		String updateStatement = "update series SET (series_id=?,series_name=?,series_cast=?,series_length=?,series_release_date=?,series_episodes=?,series_language=?,series_agelimit=?,series_genre=? where series_id = ?" ;
		
		PreparedStatement prepStatement = null;
		try {
			prepStatement = connection.prepareStatement(updateStatement);
			prepStatement.setString(1,series.getSeries_id());
			prepStatement.setString(2,series.getSeries_name());
			prepStatement.setString(3,series.getSeries_cast());
			prepStatement.setInt(4,series.getSeries_length());
			prepStatement.setString(5,series.getSeries_release_date());
			prepStatement.setInt(6,series.getSeries_episodes());
			prepStatement.setString(7,series.getSeries_language());
			prepStatement.setInt(8,series.getSeries_agelimit());
			prepStatement.setString(9,series.getSeries_genre());
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
			dbutils.closeConnection(connection);
		}
		return "fail";

		
}
}

