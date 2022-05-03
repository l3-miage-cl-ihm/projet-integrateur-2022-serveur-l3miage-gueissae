package com.example.controller.Question;

import java.util.List;

import com.example.model.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class QuestionController {
    
    private final QuestionService questionService; 

    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<List<Question>>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/{identifiant}")
    public ResponseEntity<Question> getQuestionByIdentifiant(@PathVariable(value = "identifiant") Integer id) {
        try {
            Question question = questionService.findByIdentifiant(id);
            if(question != null)
                return new ResponseEntity<Question>(question, HttpStatus.OK);
            else
                return new ResponseEntity<Question>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Question> addNewQuestion(@RequestBody Question question) {
        try {
            questionService.addNewQuestion(question);
            return new ResponseEntity<Question>(question, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Question>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //TO DO REMOVE
}
