package com.Springboot.FinalProject.OTT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.FinalProject.OTT.dto.MovieDto;
import com.Springboot.FinalProject.OTT.dto.TvshowDto;
import com.Springboot.FinalProject.OTT.entity.Movies;
import com.Springboot.FinalProject.OTT.entity.Tvshows;
import com.Springboot.FinalProject.OTT.repository.TvshowsRepository;
import com.Springboot.FinalProject.OTT.service.TvshowsService;

@RestController
@RequestMapping("/tvshows")
public class Tvshowscontroller{

	@Autowired
	private TvshowsService tvshowsservice;
	
	@Autowired
	private TvshowsRepository tvshowsrepository;
	
	@PostMapping
	public Tvshows saveTvshow(@RequestBody TvshowDto tvshowDto) {
	
	return tvshowsservice.saveTvshow(tvshowDto);
	}
	
	@GetMapping
	public List<Tvshows>getAllTvshows(){
		return tvshowsservice.findAllTvshows();
	}
	
	@GetMapping("/tvshows/{id}")
	public Tvshows getTvshowsById(@PathVariable long id) {
		return tvshowsservice.findByTvshowsId(id);
	}
	
	
	@DeleteMapping("/{tvshowsid}")
	
	public int deleteTvshowsById(@PathVariable("tvshowsid")long tvshowsid) {
		return tvshowsservice.deleteTvshowsById(tvshowsid);
	}


	@PutMapping("/tvshows/{id}")
	   public Tvshows updateTvshows(@PathVariable long id,@RequestBody TvshowDto tvshowDto) {
		  return  tvshowsservice.editTvshows(tvshowDto,id);
	}
	
	
	
}