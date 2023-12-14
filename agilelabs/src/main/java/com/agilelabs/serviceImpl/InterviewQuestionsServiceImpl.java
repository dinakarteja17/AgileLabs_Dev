package com.agilelabs.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agilelabs.dto.InterviewQuestionsDTO;
import com.agilelabs.entity.CoursesEntity;
import com.agilelabs.entity.InterviewQuestionsEntity;
import com.agilelabs.exception.NotFoundException;
import com.agilelabs.repository.CoursesRepository;
import com.agilelabs.repository.InterviewQuestionsRepository;
import com.agilelabs.service.InterviewQuestionsService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InterviewQuestionsServiceImpl implements InterviewQuestionsService {

    @Autowired
    private InterviewQuestionsRepository interviewQuestionsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CoursesRepository coursesRepository;

    @Override
    @Transactional
    public InterviewQuestionsDTO createInterviewQuestion(InterviewQuestionsDTO interviewQuestionsDTO) {
        // Map other fields
        InterviewQuestionsEntity entity = modelMapper.map(interviewQuestionsDTO, InterviewQuestionsEntity.class);

        // Set the course based on the provided course ID
        if (interviewQuestionsDTO.getCourse_id() != 0) {
            CoursesEntity course = coursesRepository.findById(interviewQuestionsDTO.getCourse_id())
                    .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + interviewQuestionsDTO.getCourse_id()));

            entity.setCourse(course);
        }
        InterviewQuestionsEntity savedEntity = interviewQuestionsRepository.save(entity);
        return modelMapper.map(savedEntity, InterviewQuestionsDTO.class);
    }

    @Override
    public InterviewQuestionsDTO getInterviewQuestionById(int id) {
        InterviewQuestionsEntity entity = interviewQuestionsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Interview question not found"));
        return modelMapper.map(entity, InterviewQuestionsDTO.class);
    }

    @Override
    public List<InterviewQuestionsDTO> getAllInterviewQuestions() {
        List<InterviewQuestionsEntity> entities = interviewQuestionsRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, InterviewQuestionsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public InterviewQuestionsDTO updateInterviewQuestion(int id, InterviewQuestionsDTO interviewQuestionsDTO) {
        InterviewQuestionsEntity existingEntity = interviewQuestionsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Interview question not found"));

        // Map only the fields you want to update
        modelMapper.map(interviewQuestionsDTO, existingEntity);

        // Update the course if a new course ID is provided
        if (interviewQuestionsDTO.getCourse_id() != 0) {
            CoursesEntity course = coursesRepository.findById(interviewQuestionsDTO.getCourse_id())
                    .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + interviewQuestionsDTO.getCourse_id()));

            existingEntity.setCourse(course);
        }

        InterviewQuestionsEntity updatedEntity = interviewQuestionsRepository.save(existingEntity);
        return modelMapper.map(updatedEntity, InterviewQuestionsDTO.class);
    }

    @Override
    @Transactional
    public void deleteInterviewQuestion(int id) {
        interviewQuestionsRepository.deleteById(id);
    }

	@Override
	public List<InterviewQuestionsDTO> getQuestionsAndAnswersByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
