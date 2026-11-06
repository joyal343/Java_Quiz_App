package com.joyal.quizapp.service;

import com.joyal.quizapp.dao.QuestionDao;
import com.joyal.quizapp.dao.QuizDao;
import com.joyal.quizapp.model.Question;
import com.joyal.quizapp.model.QuestionWrapper;
import com.joyal.quizapp.model.QuestionWrapper2;
import com.joyal.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findNRandomQuestions(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper2>> getQuiz(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper2> questions = new ArrayList<>();
        for (Question q : questionsFromDB){
            QuestionWrapper2 qw = new QuestionWrapper2(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questions.add(qw);
        }
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }
}
