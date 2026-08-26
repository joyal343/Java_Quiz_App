package com.joyal.quizapp.dao;

import com.joyal.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> { // JPA handles mapping from sql to entity/model

}
