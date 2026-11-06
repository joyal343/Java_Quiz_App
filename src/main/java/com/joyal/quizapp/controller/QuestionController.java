package com.joyal.quizapp.controller;

import com.joyal.quizapp.model.Question;
import com.joyal.quizapp.model.QuestionWrapper;
import com.joyal.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        QuestionWrapper questionsEntity = questionService.getAllQuestions();

        if (!questionsEntity.success){
            return new ResponseEntity<>(new ArrayList<Question>(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(questionsEntity.questions,HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
}
