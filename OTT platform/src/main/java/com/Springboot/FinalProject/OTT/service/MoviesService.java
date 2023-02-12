package com.Springboot.FinalProject.OTT.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.dto.MovieDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Movies;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.GenreRepository;
import com.Springboot.FinalProject.OTT.repository.MoviesRepository;

import jakarta.transaction.Transactional;


@Service
public class MoviesService {

	@Autowired
	private MoviesRepository movierepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	private ModelMapper modelMapper =new ModelMapper();
	
	 
	public Movies saveMovie(MovieDto movieDto) {
		
		
		
//		Movie movie1=new Movie();
//		movie1.setDuration(movieDto.getDuration());
//      movie1.setMovieName(movieDto.getMovieName());
		Movies movie1=modelMapper.map(movieDto,Movies.class);
		Set<Genre> genres =new HashSet<>();
		movieDto.getGenres().forEach((genreId)->{
			genres.add(genreRepository.findById(genreId).get());
		});
		movie1.setGenres(genres);
		
		Movies save = movierepository.save(movie1);
		return save;
		
	}
	
	
	
	
	public List<Movies> listMovies(Movies movies){
		return movierepository.findAll();
	}
	@Transactional
	public int deleteMoviesbyId(long movieId) {
		return movierepository.deleteMoviesByMovieid(movieId);
	}
	public List<Movies> findAllMovies() {
		
		return movierepository.findAll();
	}
	public Movies findbyMovieId(long movieId) {
		
		return (Movies)movierepository.findById(movieId).get();
	}

	
	public Movies editMovies(MovieDto movieDto, long id) {
		//Movies movies= movierepository.findById(id).get();
		//movies.setDuration(movieDto.getDuration());
		//movies.setMovieName(movieDto.getMovieName());
		Movies movies=modelMapper.map(movieDto,Movies.class);
		Set<Genre> genres =new HashSet<>();
		movieDto.getGenres().forEach((genreId)->{
			genres.add(genreRepository.findById(genreId).get());
		});
		
	Genre genre1 = genreRepository.findById(movieDto.getGenreId()).get();
		
		movies.setGenres(genres);
		Movies save = movierepository.save(movies);
		
		return movierepository.save(movies);


	}
}
