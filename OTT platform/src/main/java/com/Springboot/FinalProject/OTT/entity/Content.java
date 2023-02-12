package com.Springboot.FinalProject.OTT.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "content")
public class Content {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long contentid;
	private String title;
	private String Country;
	
	@ManyToMany(mappedBy = "contents")
	private List<Subscription> subscriptions;
	
	private String contenttype;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "content_genre",
			joinColumns =  @JoinColumn(name = "contentid"),
			inverseJoinColumns = @JoinColumn(name = "genreid"))
	
	private List<Genre> genres;

}