package com.spring.dto;


public class TeacherDTO {
	
	private Long teacherID;
	
	private String teacherName;
	
	private int teacherRoll;
	
	private String email;
	
	
	
	public TeacherDTO() {
		super();
	}

	public Long getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(Long teacherID) {
		this.teacherID = teacherID;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public int getTeacherRoll() {
		return teacherRoll;
	}

	public void setTeacherRoll(int teacherRoll) {
		this.teacherRoll = teacherRoll;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
