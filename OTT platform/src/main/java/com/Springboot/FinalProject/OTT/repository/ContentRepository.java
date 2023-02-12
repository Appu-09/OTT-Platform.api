package com.Springboot.FinalProject.OTT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Content;
@Repository
public interface ContentRepository extends JpaRepository<Content,Long> {

	int deleteByContentid(long contentId);

	

}
