package com.joyal.quizapp.dao;

import com.joyal.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> { // JPA handles mapping from sql to entity/model
    List<Question> findByCategory(String category); // Spring is smart - It will know category is part of DB!!!!!!!!!!!!
}
