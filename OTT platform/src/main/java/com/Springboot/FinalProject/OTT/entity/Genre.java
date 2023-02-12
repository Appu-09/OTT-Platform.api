package com.Springboot.FinalProject.OTT.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genre")
public class Genre {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long genreid;
	private String description;
	
	@ManyToMany(mappedBy = "genres")
	private List<Content> contents;
}



