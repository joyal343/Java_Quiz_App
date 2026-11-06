package com.joyal.quizapp.service;

import com.joyal.quizapp.model.Question;
import com.joyal.quizapp.model.QuestionWrapper;
import com.joyal.quizapp.dao.QuestionDao;
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

    public QuestionWrapper getAllQuestions() {
        QuestionWrapper questionEntity = new QuestionWrapper();
        try {
            questionEntity.questions = questionDao.findAll();
            questionEntity.success = true;
            return questionEntity;
        } catch (Exception e) {
            e.printStackTrace();
        }
        questionEntity.success = false;
        return questionEntity;
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("failed",HttpStatus.BAD_REQUEST);

    }
}