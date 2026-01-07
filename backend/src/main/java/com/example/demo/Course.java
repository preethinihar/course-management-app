package com.example.demo;
import jakarta.persistence.*;
@Entity
public class Course {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String instructor;
  public Long getId(){return id;}
  public String getTitle(){return title;}
  public String getInstructor(){return instructor;}
  public void setId(Long id){this.id=id;}
  public void setTitle(String t){this.title=t;}
  public void setInstructor(String i){this.instructor=i;}
}
