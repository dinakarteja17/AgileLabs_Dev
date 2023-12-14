package com.agilelabs.rest;

import com.agilelabs.dto.InterviewQuestionsDTO;
import com.agilelabs.service.InterviewQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/interview-questions")
public class InterviewQuestionsController {
    @Autowired
    private InterviewQuestionsService interviewQuestionsService;

    @PostMapping("/createInterviewQuestion")
    public ResponseEntity<InterviewQuestionsDTO> createInterviewQuestion(@RequestBody InterviewQuestionsDTO interviewQuestionsDTO) {
        InterviewQuestionsDTO createdDTO = interviewQuestionsService.createInterviewQuestion(interviewQuestionsDTO);
        return new ResponseEntity<>(createdDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getInterviewQuestion/{id}")
    public ResponseEntity<InterviewQuestionsDTO> getInterviewQuestionById(@PathVariable int id) {
        InterviewQuestionsDTO dto = interviewQuestionsService.getInterviewQuestionById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    
    
    @GetMapping("/getQuestionsAndAnswersByCourseId/{courseId}")
    public ResponseEntity<List<InterviewQuestionsDTO>> getQuestionsAndAnswersByCourseId(@PathVariable int courseId) {
        List<InterviewQuestionsDTO> dtos = interviewQuestionsService.getQuestionsAndAnswersByCourseId(courseId);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


    @GetMapping("/getAllInterviewQuestions")
    public ResponseEntity<List<InterviewQuestionsDTO>> getAllInterviewQuestions() {
        List<InterviewQuestionsDTO> dtos = interviewQuestionsService.getAllInterviewQuestions();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PutMapping("/updateInterviewQuestion/{id}")
    public ResponseEntity<InterviewQuestionsDTO> updateInterviewQuestion(
            @PathVariable int id,
            @RequestBody InterviewQuestionsDTO interviewQuestionsDTO) {
        InterviewQuestionsDTO updatedDTO = interviewQuestionsService.updateInterviewQuestion(id, interviewQuestionsDTO);
        return new ResponseEntity<>(updatedDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteInterviewQuestion/{id}")
    public ResponseEntity<Void> deleteInterviewQuestion(@PathVariable int id) {
        interviewQuestionsService.deleteInterviewQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
