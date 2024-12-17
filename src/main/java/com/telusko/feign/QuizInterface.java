package com.telusko.feign;

import com.telusko.payload.Answers;
import com.telusko.payload.QuestionsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("question/generate")
    public ResponseEntity<List<Long>> getQuestionForQuiz(@RequestParam String category, @RequestParam Long numOfQuestion);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionsDto>> getQuestions(@RequestBody List<Long> questionIds);

    @PostMapping("question/getscore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Answers> answers);
}
