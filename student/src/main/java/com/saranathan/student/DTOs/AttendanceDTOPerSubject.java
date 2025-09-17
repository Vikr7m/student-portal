package com.saranathan.student.DTOs;

import java.math.BigDecimal;

public class AttendanceDTOPerSubject {
	
	private String subjectId;
	private String subjectName;
    private BigDecimal totalPresent;
    private BigDecimal totalAbsent;
    private Long totalPeriods;
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
	public BigDecimal getTotalPresent() {
		return totalPresent;
	}
	public void setTotalPresent(BigDecimal totalPresent) {
		this.totalPresent = totalPresent;
	}
	public BigDecimal getTotalAbsent() {
		return totalAbsent;
	}
	public void setTotalAbsent(BigDecimal totalAbsent) {
		this.totalAbsent = totalAbsent;
	}
	public Long getTotalPeriods() {
		return totalPeriods;
	}
	public void setTotalPeriods(Long totalPeriods) {
		this.totalPeriods = totalPeriods;
	}
	

}
