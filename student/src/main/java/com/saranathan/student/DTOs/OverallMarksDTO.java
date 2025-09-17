package com.saranathan.student.DTOs;

public class OverallMarksDTO {
	
	private double cgpa;
	private int totalSubjects;
	private int subjectsPassed;
	private int currentArrears;
	private int historyOfArrears;
	
	
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public int getTotalSubjects() {
		return totalSubjects;
	}
	public void setTotalSubjects(int totalSubjects) {
		this.totalSubjects = totalSubjects;
	}
	public int getSubjectsPassed() {
		return subjectsPassed;
	}
	public void setSubjectsPassed(int subjectsPassed) {
		this.subjectsPassed = subjectsPassed;
	}
	public int getCurrentArrears() {
		return currentArrears;
	}
	public void setCurrentArrears(int currentArrears) {
		this.currentArrears = currentArrears;
	}
	public int getHistoryOfArrears() {
		return historyOfArrears;
	}
	public void setHistoryOfArrears(int historyOfArrears) {
		this.historyOfArrears = historyOfArrears;
	}
}
