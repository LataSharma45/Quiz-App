package com.telusko.quizapp.Controller;

import com.telusko.quizapp.Model.Questions;
import com.telusko.quizapp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allquestions")
    public ResponseEntity<List<Questions>> getAllQuestions() {
        return questionService.getallQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question) {
        // Logic to add a new question
     return questionService.addQuestion(question);
        //return "Question added successfully";
    }
}
