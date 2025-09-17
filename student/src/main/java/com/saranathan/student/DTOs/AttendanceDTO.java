package com.saranathan.student.DTOs;

import java.math.BigDecimal;
import java.util.List;

public class AttendanceDTO {
	
	private BigDecimal attendancePercentage;
	private BigDecimal totalHours;
	private BigDecimal totalPresent;
	private BigDecimal totalAbsent;
	private List<AttendanceDTOSubject> attendancePerSubject;
	public BigDecimal getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(BigDecimal attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	public BigDecimal getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(BigDecimal totalHours ) {
		this.totalHours = totalHours;
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
	public List<AttendanceDTOSubject> getAttendancePerSubject() {
		return attendancePerSubject;
	}
	public void setAttendancePerSubject(List<AttendanceDTOSubject> attendancePerSubject) {
		this.attendancePerSubject = attendancePerSubject;
	}

}
