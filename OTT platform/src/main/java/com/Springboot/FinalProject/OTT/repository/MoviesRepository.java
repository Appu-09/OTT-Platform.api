package com.Springboot.FinalProject.OTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Long> {

	int deleteMoviesByMovieid(long moviesId);

}
