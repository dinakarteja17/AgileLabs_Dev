package com.agilelabs.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agilelabs.dto.InterviewQuestionsDTO;
import com.agilelabs.entity.InterviewQuestionsEntity;

public interface InterviewQuestionsRepository extends JpaRepository<InterviewQuestionsEntity, Integer> {

	Optional<InterviewQuestionsEntity> findById(int id);

	void deleteById(int id);

	

}
