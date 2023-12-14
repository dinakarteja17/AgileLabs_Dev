package com.agilelabs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agilelabs.entity.CoursesEntity;

public interface CoursesRepository extends JpaRepository<CoursesEntity, Integer>{

	CoursesEntity findByCourseName(String courseName);

	Optional<CoursesEntity> findById(Long id);

	void deleteById(Long id);

}
