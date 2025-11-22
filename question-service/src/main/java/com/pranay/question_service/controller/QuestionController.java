package com.pranay.question_service.controller;


import com.pranay.question_service.model.Question;
import com.pranay.question_service.model.QuestionWrapper;
import com.pranay.question_service.model.Response;
import com.pranay.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
     return questionService.addQuestion(question);
    }
    //generate a quiz
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName,@RequestParam Integer numOfQuestions) {
        return questionService.getQuestionsForQuiz(categoryName,numOfQuestions);
    }


    @GetMapping("categories")
    public ResponseEntity<List<String>> getAllCategories() {
        return questionService.getAllCategories();
    }

    //getquestion for a particular questionid
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        return questionService.getQuestionsForIds(questionIds);
    }

    // score
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        return questionService.getScore(responses);
    }

}
