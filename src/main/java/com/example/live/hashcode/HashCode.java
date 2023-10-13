package com.example.live.hashcode;

import jakarta.persistence.*;

@Entity
@Table(name = "hashcode")
public class HashCode {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "userID")
  private String userID;
  
  @Column(name = "hashcode")
  private String hashcode;

  @Column(name = "startTime")
  private String startTime;




  //getters and setters


public String getStartTime() {
	return startTime;
}

public void setStartTime(String startTime) {
	this.startTime = startTime;
}

public String getUserID() {
	return userID;
}

public void setUserID(String userID) {
	this.userID = userID;
}

public String getHashcode() {
	return hashcode;
}

public void setHashcode(String hashcode) {
	this.hashcode = hashcode;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}