package com.telusko.payload;


import lombok.Data;

@Data
public class QuizDto {
    private String category;
    private Long numOfQuestion;
    private String title;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getNumOfQuestion() {
        return numOfQuestion;
    }

    public void setNumOfQuestion(Long numOfQuestion) {
        this.numOfQuestion = numOfQuestion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
