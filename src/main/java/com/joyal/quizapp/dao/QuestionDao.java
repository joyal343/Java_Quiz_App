package com.joyal.quizapp.dao;

import com.joyal.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> { // JPA handles mapping from sql to entity/model
    List<Question> findByCategory(String category); // Spring is smart - It will know category is part of DB!!!!!!!!!!!!

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Question> findNRandomQuestions(String category, int numQ);
}
