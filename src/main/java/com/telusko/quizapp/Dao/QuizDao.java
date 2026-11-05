package com.telusko.quizapp.Dao;

import com.telusko.quizapp.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
