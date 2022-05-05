package com.example.ControllerEtService.Question;

import java.util.List;

import com.example.model.Question;
import com.example.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
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

    public Question updateQuestion(Question question) {
        Question  updatedQuestion = questionRepository.findByIdentifiant(question.getIdentifiant());
        updatedQuestion.setNumero(question.getNumero());
        updatedQuestion.setDescription(question.getDescription());
        updatedQuestion.setIndices(question.getIndices());
        updatedQuestion.setLabel(question.getLabel());
        updatedQuestion.setRepondres(question.getRepondres());
        updatedQuestion.setReponses(question.getReponses());
        questionRepository.save(updatedQuestion);
        return updatedQuestion;
    }

    public void deleteQuestion(Integer identifiant){
        Question deletedQuestion = questionRepository.findByIdentifiant(identifiant);
        questionRepository.delete(deletedQuestion);
    }
}
