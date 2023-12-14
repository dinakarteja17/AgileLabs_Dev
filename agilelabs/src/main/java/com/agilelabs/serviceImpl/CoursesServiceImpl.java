package com.agilelabs.serviceImpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agilelabs.dto.CoursesDTO;
import com.agilelabs.entity.CoursesEntity;
import com.agilelabs.exception.DuplicateCourseException;
import com.agilelabs.repository.CoursesRepository;

@Service
public class CoursesServiceImpl {

	@Autowired
	private CoursesRepository coursesRepository;

	public CoursesEntity createCourse(CoursesDTO coursesDTO) {
		CoursesEntity existingCourse = coursesRepository.findByCourseName(coursesDTO.getCourseName());
		if (existingCourse == null) {
			// Course with the specified name does not exist, create a new one
			CoursesEntity course = new CoursesEntity();
			BeanUtils.copyProperties(coursesDTO, course);
			return coursesRepository.save(course);
		} else {
			throw new DuplicateCourseException("Course with the specified name already exists");
		}
	}

	public CoursesEntity getCourseById(Long id) {
		return coursesRepository.findById(id).orElse(null);
	}

	public List<CoursesEntity> getAllCourses() {
		return coursesRepository.findAll();
	}

	public CoursesEntity updateCourse(Long id, CoursesDTO coursesDTO) {
		CoursesEntity existingCourse = coursesRepository.findById(id).orElse(null);

		if (existingCourse != null) {
			BeanUtils.copyProperties(coursesDTO, existingCourse);
			return coursesRepository.save(existingCourse);
		}

		return null; // or throw an exception indicating that the course with the given ID was not
						// found
	}

	public void deleteCourse(Long id) {
		coursesRepository.deleteById(id);
	}

}
