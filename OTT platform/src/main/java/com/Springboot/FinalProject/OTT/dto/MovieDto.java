package com.Springboot.FinalProject.OTT.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDto {
	private int duration;
	private String movieName;
	private List<Long> genres;
	public Long getGenreId() {
		
		return null;
	}

}
