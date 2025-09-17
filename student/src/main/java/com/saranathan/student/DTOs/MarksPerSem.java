package com.saranathan.student.DTOs;

public class MarksPerSem {
	private String subjectId;
	private String subjectName;
	private int ia1Marks;
	private int ia2Marks;
	private int ia3Marks;
	private String semGrade;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getIa1Marks() {
		return ia1Marks;
	}
	public void setIa1Marks(int ia1Marks) {
		this.ia1Marks = ia1Marks;
	}
	public int getIa2Marks() {
		return ia2Marks;
	}
	public void setIa2Marks(int ia2Marks) {
		this.ia2Marks = ia2Marks;
	}
	public int getIa3Marks() {
		return ia3Marks;
	}
	public void setIa3Marks(int ia3Marks) {
		this.ia3Marks = ia3Marks;
	}
	public String getSemGrade() {
		return semGrade;
	}
	public void setSemGrade(String semGrade) {
		this.semGrade = semGrade;
	}

}
