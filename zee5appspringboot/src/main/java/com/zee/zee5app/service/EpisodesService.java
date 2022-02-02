package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.exception.IdNotFoundException;



public interface EpisodesService{
	public String addEpisodes(Episodes episodes);
	public String updateEpisodes(String id, Episodes episodes);
	public Optional<Episodes> getEpisodesById(String id);
	public Episodes[] getAllEpisodess();
	public Optional<List<Episodes>> getAllEpisodesDetails();
	public String deleteEpisodesById(String id) throws IdNotFoundException;


}
