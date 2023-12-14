package com.agilelabs.service;

import com.agilelabs.dto.InterviewQuestionsDTO;

import java.util.List;

public interface InterviewQuestionsService {
    InterviewQuestionsDTO createInterviewQuestion(InterviewQuestionsDTO interviewQuestionsDTO);

    InterviewQuestionsDTO getInterviewQuestionById(int id);

    List<InterviewQuestionsDTO> getAllInterviewQuestions();

    InterviewQuestionsDTO updateInterviewQuestion(int id, InterviewQuestionsDTO interviewQuestionsDTO);

    List<InterviewQuestionsDTO> getQuestionsAndAnswersByCourseId(int courseId);
    void deleteInterviewQuestion(int id);
}
