package com.Springboot.FinalProject.OTT.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movies {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long movieid;
	private String movieName;
	private int duration;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "movie_genre",
			joinColumns = @JoinColumn(name = "movie_Id"),
			inverseJoinColumns = @JoinColumn(name = "genreid"))
	private Set<Genre> genres;
	
			
			
	
}
