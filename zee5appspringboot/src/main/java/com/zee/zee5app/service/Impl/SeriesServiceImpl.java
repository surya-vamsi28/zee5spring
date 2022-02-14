package com.zee.zee5app.service.Impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.IdNotValidException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.SeriesService;
import com.zee.zee5app.repository.SeriesRepository;


@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	public SeriesRepository repository;

	@Override
	public Series addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 = repository.save(series);
		if (series2 != null) {
			return series2;
		} else {
			return null;
		}
	}

	@Override
	public String deleteSeries(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Series optional;
		try {
			optional = this.getSeriesById(id);
			if(optional == null) {
				throw new IdNotFoundException("record not found");
			}
			else {
				repository.deleteById(id);
				return "series record deleted";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());
		}
	}

	@Override
	public String modifySeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Series getSeriesById(String id) throws IdNotFoundException, NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		Optional<Series> optional =  repository.findById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("id does not exists");
		}
		else {
			return optional.get();
		}

	}

	@Override
	public Optional<List<Series>> getAllSeries() throws NameNotFoundException, InvalidIdLengthException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}


}
