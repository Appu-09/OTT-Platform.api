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

import com.Springboot.FinalProject.OTT.dto.GenreDto;
import com.Springboot.FinalProject.OTT.dto.MovieDto;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Movies;
import com.Springboot.FinalProject.OTT.repository.MoviesRepository;
import com.Springboot.FinalProject.OTT.service.MoviesService;

@RestController
@RequestMapping("/movies")
public class Moviescontroller {

	@Autowired
	private MoviesService moviesservice;
	
	@Autowired
	private  MoviesRepository moviesrepository;
	
	
	@PostMapping
	public Movies saveMovie(@RequestBody  MovieDto movieDto) {
		return moviesservice.saveMovie(movieDto);
	}
	
	@GetMapping
	public List<Movies>getAllMovies(){
		 return moviesservice.findAllMovies();
	}
	
	
	@GetMapping("/movies/{id}")
	public Movies getMovieById(@PathVariable long id) {
		return moviesservice.findbyMovieId(id);
	}
	
	@DeleteMapping("/{movieid}")
	public int deleteMoviesByMovieId(@PathVariable("movieid")long movieid) {
		return moviesservice.deleteMoviesbyId(movieid);
	}
	
	@PutMapping("/movies/{id}")
	   public Movies updateMovies(@PathVariable long id,@RequestBody MovieDto movieDto) {
		  return  moviesservice.editMovies(movieDto,id);
	}
}