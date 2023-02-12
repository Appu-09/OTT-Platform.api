package com.Springboot.FinalProject.OTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Tvshows;

@Repository
public interface TvshowsRepository  extends JpaRepository<Tvshows,Long>{

	int deleteTvshowsByTvshowsid(long tvshowsId);

}
