package com.saranathan.student.DTOs;

import java.util.List;

public class StudentDashboardDTO {
	
	private String name;
	private Integer batchNo;
	private String department;
	private float cgpa;
	
	private int ia1;
	private int ia2;
	private int ia3;
	private float attendance;
	private float feesDue;
	private List<SubjectStaffDTO>subjectStaffs;
	private int dayOrder;
	private List<TimetableDTO> timetable;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(int batchNo) {
		this.batchNo = batchNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getCgpa() {
		return cgpa;
	}
	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
	public float getAttendance() {
		return attendance;
	}
	public void setAttendance(float attendance) {
		this.attendance = attendance;
	}
	public float getFeesDue() {
		return feesDue;
	}
	public void setFeesDue(float feesDue) {
		this.feesDue = feesDue;
	}
	public List<SubjectStaffDTO> getSubjectStaffs() {
		return subjectStaffs;
	}
	public void setSubjectStaffs(List<SubjectStaffDTO> subjectStaffs) {
		this.subjectStaffs = subjectStaffs;
	}
	public int getIa1() {
		return ia1;
	}
	public void setIa1(int ia1) {
		this.ia1 = ia1;
	}
	public int getIa2() {
		return ia2;
	}
	public void setIa2(int ia2) {
		this.ia2 = ia2;
	}
	public int getIa3() {
		return ia3;
	}
	public void setIa3(int ia3) {
		this.ia3 = ia3;
	}
	public List<TimetableDTO> getTimetable() {
		return timetable;
	}
	public void setTimetable(List<TimetableDTO> list) {
		this.timetable = list;
	}
	public int getDayOrder() {
		return dayOrder;
	}
	public void setDayOrder(int dayOrder) {
		this.dayOrder = dayOrder;
	}
	
	

}
