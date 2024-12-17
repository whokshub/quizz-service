package com.telusko.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.telusko.payload.QuestionsDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "quiz")
public class Quiz {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  @JsonProperty("id")
  private Long id;

  @Column(name = "title", nullable = false)
  @JsonProperty("title")
  private String title;

  @ElementCollection
  private List<Long> questionIDs;

  public List<Long> getQuestionIDs() {
    return questionIDs;
  }

  public void setQuestionIDs(List<Long> questionIDs) {
    this.questionIDs = questionIDs;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }
}