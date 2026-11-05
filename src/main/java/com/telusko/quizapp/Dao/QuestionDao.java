package com.telusko.quizapp.Dao;

import com.telusko.quizapp.Model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Questions, Integer> {
    List<Questions> findByCategory(String category);

    @Query(value = "SELECT * FROM question WHERE a category =: ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Questions> findRandomQuestionByCategory(String categoory, int numQ);
}
