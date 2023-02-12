package com.Springboot.FinalProject.OTT.dto;

import java.util.List;

import com.Springboot.FinalProject.OTT.entity.Genre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvshowDto {
	private int noofseasons;
	private List<Long> genres;
	public Long getGenreId() {
		
		return null;
	}
	}

