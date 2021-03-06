package com.example.ControllerEtService.Question;

import java.util.List;

import com.example.ControllerEtService.Indice.IndiceService;
import com.example.ControllerEtService.Reponse.ReponseService;
import com.example.model.Indice;
import com.example.model.Question;
import com.example.model.Reponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@CrossOrigin
@RequestMapping("/api/question")
public class QuestionController {
    
    private final QuestionService questionService; 
    private final IndiceService indiceService;
    private final ReponseService reponseService;

    @Autowired
    public QuestionController(QuestionService questionService, IndiceService indiceService, ReponseService responseService){
        this.questionService = questionService;
        this.indiceService = indiceService;
        this.reponseService = responseService;
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
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question) {
        try {
            Question q = questionService.updateQuestion(question);
            System.out.println(q.getIdentifiant());
            return new ResponseEntity<Question>(q, HttpStatus.OK);
        } catch (IllegalStateException e) {
            return new ResponseEntity<Question>( HttpStatus.BAD_REQUEST );
        }
    }

    // TODO: tests

    @DeleteMapping("/")
    public ResponseEntity<Question> deleteQuestion(@RequestBody Integer identifiant){
        try{
            Question questionDeleted = questionService.findByIdentifiant(identifiant);
            List<Indice> indices = questionDeleted.getIndices();
            List<Reponse> reponses = questionDeleted.getReponses();
            for(Indice indice : indices){
                indiceService.deleteIndiceById(indice.getIdentifiant());
            }
            for(Reponse reponse : reponses){
                reponseService.deleteReponseById(reponse.getIdentifiant());
            }
            questionService.deleteQuestion(identifiant);
            return new ResponseEntity<Question>(HttpStatus.OK);
        }
        catch(IllegalStateException e){
            return new ResponseEntity<Question>(HttpStatus.BAD_REQUEST);
        }
    }
}
