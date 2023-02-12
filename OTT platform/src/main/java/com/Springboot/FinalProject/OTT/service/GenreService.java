package com.Springboot.FinalProject.OTT.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.dto.GenreDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.GenreRepository;

import jakarta.transaction.Transactional;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genrerepository;
	 
	private ModelMapper modelMapper =new ModelMapper();
	 
	public Genre  saveGenre(GenreDto genreDto) {
	//Genre genre1= new Genre();
	//genre1.setDescription(genreDto.getDescription());
	Genre genre1 = modelMapper.map(genreDto,Genre.class);
	
	Genre save = genrerepository.save(genre1);
	
		return save;
	}
	public List<Genre> listGenre(Genre genre){
		return genrerepository.findAll();
	}
	@Transactional
	public int deleteGenrebyGenreId(long genreId) {
		return genrerepository.deleteByGenreid(genreId);
	}
	public Genre findbyGenreId(long genreId) {
		return (Genre) genrerepository.findById(genreId).get();
	}
	
//	public Genre findAllGenresbyGenreId(long genreId) {}
	public List<Genre> findAllGenres() {
		  
		return genrerepository.findAll();
	}
	
	public Genre editGenre(GenreDto genreDto, long id) {
		Genre genre = genrerepository.findById(id).get();
		genre.setDescription(genreDto.getDescription());
		return genrerepository.save(genre);
	
	}
	}
	
	
	
	
	

