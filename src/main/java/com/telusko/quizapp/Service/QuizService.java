package com.telusko.quizapp.Service;

import com.telusko.quizapp.Dao.QuestionDao;
import com.telusko.quizapp.Dao.QuizDao;
import com.telusko.quizapp.Model.QuestionWrapper;
import com.telusko.quizapp.Model.Questions;
import com.telusko.quizapp.Model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
     private QuizDao quizdao;
    @Autowired
     private QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String categoory, int numQ, String title) {
        List<Questions> questions = questionDao.findRandomQuestionByCategory(categoory,numQ);

        if (questions.isEmpty()) {
            return new ResponseEntity<>(
                    "No questions found for this category",
                    HttpStatus.NOT_FOUND
            );
        }

        Quiz quiz =new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
       Optional<Quiz> quiz= quizdao.findById(id);
       List<Questions> questionsFromDb =quiz.get().getQuestions();
       List<QuestionWrapper> questionForUser= new ArrayList<>();
       for(Questions q: questionsFromDb){
           QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getCategory(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),
                   q.getOption3(),q.getOption4());
           questionForUser.add(qw);
       }
       return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }
}


