package com.saranathan.student.DTOs;

public class TimetableDTO {
	
	private int periodNo;
	private String subjectId;
	private String subjectName;
	private String staffName;
	private String startTime;
	private String endTime;
	
	private String[][] timings = {{"09:15","10:05"},{"10:05","10:55"},{"11:05","11:55"},{"11:55","12:45"},{"01:25","02:15"},{"02:15","03:05"},{"03:15","04:00"},{"04:00","04:45"}};
	
	
	public int getPeriodNo() {
		return periodNo;
	}
	public void setPeriodNo(int periodNo) {
		this.periodNo = periodNo;
	}
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
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime() {
		this.startTime = timings[periodNo-1][0];
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime() {
		this.endTime = timings[periodNo-1][1];
	}
	
}
