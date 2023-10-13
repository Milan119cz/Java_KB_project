package com.example.live.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;
  
  @Column(name = "secondname")
  private String secondname;


@Column(name = "email")
  private String email;
  
  @Column(name = "phone")
  private String phone;


  //getters and setters

  public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;

  }
  
  public String getSecondname() {
	return secondname;
}

public void setSecondname(String secondname) {
	this.secondname = secondname;
}
}
