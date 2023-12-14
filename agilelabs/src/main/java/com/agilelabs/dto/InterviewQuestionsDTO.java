package com.agilelabs.dto;

import com.agilelabs.entity.CoursesEntity;

public class InterviewQuestionsDTO {

	    private int id;
	    private CoursesEntity course;
	    private String question;
	    private String answer;
	    private int course_id;
	    public InterviewQuestionsDTO() {
	    }
	    public InterviewQuestionsDTO(int id, CoursesEntity course, String question, String answer, int course_id) {
	        this.id = id;
	        this.course = course;
	        this.question = question;
	        this.answer = answer;
	        this.course_id = course_id;
	    }
		public int getCourse_id() {
		return course_id;
		}
		public void setCourse_id(int course_id) {
			this.course_id = course_id;
		}
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
