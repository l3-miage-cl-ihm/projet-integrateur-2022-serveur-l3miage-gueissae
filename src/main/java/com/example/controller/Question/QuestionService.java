package com.example.controller.Question;

import java.util.List;

import com.example.model.Question;
import com.example.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public void addNewQuestion(Question question){
        questionRepository.save(question);
    }

    public Question findByIdentifiant(Integer id){
        return questionRepository.findByIdentifiant(id);
    }
}
