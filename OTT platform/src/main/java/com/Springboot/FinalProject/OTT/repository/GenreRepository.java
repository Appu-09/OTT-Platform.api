package com.Springboot.FinalProject.OTT.repository;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

	

	int deleteByGenreid(long genreId);
   
}
