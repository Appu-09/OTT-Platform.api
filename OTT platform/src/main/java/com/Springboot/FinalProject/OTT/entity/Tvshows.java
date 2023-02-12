package com.Springboot.FinalProject.OTT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name =  "Tvshows")
public class Tvshows {

	@Id
	@GeneratedValue
	private long tvshowsid;
	private int noofseasons;
	
	@ManyToMany(cascade =  CascadeType.ALL)
	@JoinTable(
			name = "tvshow_genre",
			joinColumns = @JoinColumn(name = "t_contentid"),
			inverseJoinColumns = @JoinColumn(name = "genreid"))
	private Set<Genre>genres;

	
	}

