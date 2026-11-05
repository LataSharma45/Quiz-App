package com.telusko.quizapp.Controller;
import java.util.List;

import com.telusko.quizapp.Model.QuestionWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.telusko.quizapp.Model.Questions;
import com.telusko.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }

//    @GetMapping("/get/{id}")
//    public ResponseEntity<List<Questions>> getQuizQuestions(@PathVariable int id) {
//        return quizService.getQuizQuestions(id);
//
//    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id) {
        return quizService.getQuizQuestions(id);
    }
}
