package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.EpisodesRepository;
import com.zee.zee5app.service.EpisodesService;

@Service
public class EpisodeServiceImpl implements EpisodesService {
	@Autowired
	private EpisodesRepository episodesRepository;
	
	private EpisodeServiceImpl() {
		
	}

	@Override
	public String addEpisodes(Episodes episodes) {
		// TODO Auto-generated method stub
		Episodes episodes2 =  episodesRepository.save(episodes);
		
		if(episodes2!=null) {
			return "add Success";
		}
		else {
			return "fail";
		}

	}

	@Override
	public String updateEpisodes(String id, Episodes episodes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Episodes> getEpisodesById(String id) {
		// TODO Auto-generated method stub
		return episodesRepository.findById(id);
	}

	@Override
	public Episodes[] getAllEpisodess() {
		// TODO Auto-generated method stub
		List<Episodes> episodes1 = episodesRepository.findAll();
		Episodes[] array = new Episodes[episodes1.size()];
		return episodes1.toArray(array);
	}

	@Override
	public Optional<List<Episodes>> getAllEpisodesDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(episodesRepository.findAll());
	}

	@Override
	public String deleteEpisodesById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Episodes> optional;
		
		optional = this.getEpisodesById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException("record not found");
		}
		else {
			episodesRepository.deleteById(id);
			return "Success";
		}

	}

}
