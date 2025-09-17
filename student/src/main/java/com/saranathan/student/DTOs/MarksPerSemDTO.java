package com.saranathan.student.DTOs;

import java.util.List;

public class MarksPerSemDTO {
	
	List<MarksPerSem> marksPerSem;
	double gpa;
	
	public List<MarksPerSem> getMarksPerSem(){
		return marksPerSem;
	}
	public void setMarksPerSem(List<MarksPerSem> marksPerSem) {
		this.marksPerSem = marksPerSem;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	

}

