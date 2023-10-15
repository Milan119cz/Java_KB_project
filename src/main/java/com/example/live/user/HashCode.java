package com.example.live.user;

import jakarta.persistence.*;

@Entity
@Table(name = "hashcode")
public class HashCode {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "hashcode")
	private Integer hashcode;

	@Column(name = "startTime")
	private String startTime;

	//getters and setters


	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}


	public Integer getHashcode() {
		return hashcode;
	}

	public void setHashcode(Integer hashcode) {
		this.hashcode = hashcode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}