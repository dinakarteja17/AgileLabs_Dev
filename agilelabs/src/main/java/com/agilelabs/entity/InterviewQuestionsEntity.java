package com.agilelabs.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "InterviewQuestions")
public class InterviewQuestionsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinColumn(name = "course_id")
	private CoursesEntity course;
	private String question;
	private String answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CoursesEntity getCourse() {
		return course;
	}

	public void setCourse(CoursesEntity course) {
		this.course = course;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
