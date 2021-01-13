package com.redhat.app.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity 
@Data
public class User {
  @Id
  // @GeneratedValue(strategy=GenerationType.AUTO)
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  private String name;

  private String email;

  
}