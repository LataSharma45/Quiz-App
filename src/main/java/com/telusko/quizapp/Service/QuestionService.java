package com.telusko.quizapp.Service;

import com.telusko.quizapp.Dao.QuestionDao;
import com.telusko.quizapp.Model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getallQuestions(){
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
 }
    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
//       try{
//         return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
//         }catch (Exception e){
//         e.printStackTrace();
//        }
//         return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        List<Questions> questions = questionDao.findByCategory(category);

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Questions question) {
        questionDao.save(question);
         return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    }
}
