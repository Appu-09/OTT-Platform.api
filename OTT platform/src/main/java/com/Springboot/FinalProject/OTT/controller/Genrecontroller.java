package com.Springboot.FinalProject.OTT.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.dto.GenreDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.repository.GenreRepository;
import com.Springboot.FinalProject.OTT.service.GenreService;

@RestController
@RequestMapping("/genre")
public class Genrecontroller {

	@Autowired
	private GenreService genreService;
	@Autowired
	private GenreRepository genreRepository;
	
	
	@PostMapping
	public Genre saveGenreDto(@RequestBody GenreDto genreDto) {
		return genreService.saveGenre(genreDto);
	}
	
	
	
	@GetMapping
	public List< Genre> getAllGenres(){
		return genreService.findAllGenres();
	}
	
	
	@GetMapping("/genre/{id}")
	public Genre getGenreById(@PathVariable    long id){
		return genreService.findbyGenreId(id);
	}
	
	
	
	@DeleteMapping(path = "/{id}")
	public int  deleteGenreByGenreId(@PathVariable("genreid")long genreid) {
		return genreService.deleteGenrebyGenreId(genreid);
	}
	
	
	@PutMapping("/genre/{id}")
	   public Genre updateGenre(@PathVariable long id,@RequestBody GenreDto genreDto) {
		  return  genreService.editGenre(genreDto,id);
	
	}
}
