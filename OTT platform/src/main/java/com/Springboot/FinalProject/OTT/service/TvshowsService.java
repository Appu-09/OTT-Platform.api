package com.Springboot.FinalProject.OTT.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.MovieDto;
import com.Springboot.FinalProject.OTT.dto.TvshowDto;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Movies;
import com.Springboot.FinalProject.OTT.entity.Tvshows;
import com.Springboot.FinalProject.OTT.repository.GenreRepository;
import com.Springboot.FinalProject.OTT.repository.TvshowsRepository;

import jakarta.transaction.Transactional;

@Service

public class TvshowsService {

	
	@Autowired
	private TvshowsRepository tvshowsrepository;
	@Autowired
	private GenreRepository genreRepository;
	 
	private ModelMapper modelMapper =new ModelMapper();
	
	 
	public Tvshows saveTvshow(TvshowDto tvshowDto) {
		
		
//		Tvshows tvshows1=new Tvshow();
//		tvshow1.setNoofSeasons(tvshowDto.getNoofSeasons());
		Tvshows tvshows1=modelMapper.map(tvshowDto,Tvshows.class);
		Set<Genre> genres =new HashSet<>();
		tvshowDto.getGenres().forEach((genreId)->{
			genres.add(genreRepository.findById(genreId).get());
		});
		tvshows1.setGenres(genres);
		
		Tvshows save = tvshowsrepository.save(tvshows1);
		return save;
	}
	
	
	public List<Tvshows>listTvshows(Tvshows tvshows){
		return tvshowsrepository.findAll();
	}
	
	@Transactional
	public int deleteTvshowsById(long tvshowsId) {
		return tvshowsrepository.deleteTvshowsByTvshowsid(tvshowsId);
	}


	public List<Tvshows> findAllTvshows() {
		
		return tvshowsrepository.findAll();
	}


	public Tvshows findByTvshowsId(long tvshowsId) {
		return (Tvshows)tvshowsrepository.findById(tvshowsId).get();
	}


	public Tvshows editTvshows(TvshowDto tvshowDto, long id) {
		
		
		Tvshows tvshows= tvshowsrepository.findById(id).get();
		tvshows.setNoofseasons(tvshowDto.getNoofseasons());
		
		
//		Tvshows tvshows=new Tvshow();
//		tvshows.setNoofSeasons(tvshowDto.getNoofSeasons());
		Tvshows tvshows1=modelMapper.map(tvshowDto,Tvshows.class);
		Set<Genre> genres =new HashSet<>();
		tvshowDto.getGenres().forEach((genreId)->{
			genres.add(genreRepository.findById(genreId).get());
		});
		tvshows1.setGenres(genres);

	Genre genre1 = genreRepository.findById(tvshowDto.getGenreId()).get();
		
		tvshows.setGenres(genres);
		Tvshows save = tvshowsrepository.save(tvshows);
		return tvshowsrepository.save(tvshows);
		
	}
	
	
}