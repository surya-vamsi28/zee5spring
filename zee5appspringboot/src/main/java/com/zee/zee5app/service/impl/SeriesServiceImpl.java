package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.SeriesService;
@Component
public class SeriesServiceImpl implements SeriesService {

	
	@Autowired
	private SeriesRepository seriesRepository;
	
	private SeriesServiceImpl() {
		
	}
	
	
	@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Series series2 =  seriesRepository.save(series);
		
		if(series2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}

	}

	@Override
	public String updateSeries(String id, Series series) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Series> getSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return seriesRepository.findById(id);
		

	}

	@Override
	public Series[] getAllSeriess() {
		// TODO Auto-generated method stub
		List<Series> series1 = seriesRepository.findAll();
		Series[] array = new Series[series1.size()];
		return series1.toArray(array);

	}

	@Override
	public Optional<List<Series>> getAllSeriesDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(seriesRepository.findAll());
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Series> optional;
		
			optional = this.getSeriesById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}
			else {
				seriesRepository.deleteById(id);
				return "Success";
			

	

	}

}
	
}

