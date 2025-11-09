package com.pranay.quiz_service.controller;


import com.pranay.quiz_service.model.QuestionWrapper;
import com.pranay.quiz_service.model.Quiz;
import com.pranay.quiz_service.model.QuizDto;
import com.pranay.quiz_service.model.Response;
import com.pranay.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@CrossOrigin("https://quiz-app-playfree.web.app")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<Quiz> createQuiz(@RequestBody QuizDto quizDto) {
        return quizService.createQuiz(quizDto.getCategoryName(),quizDto.getNumQuestions(),quizDto.getTitle());

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
       return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        return quizService.calculateResult(id,responses);

    }

}
