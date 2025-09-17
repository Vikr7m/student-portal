package com.saranathan.student.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name =  "class_timetable")
public class Timetable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "timetable_id")
	private Long timetableId;

	@Column(name = "class_id", nullable = false)
	private Long classId;

	@Column(name = "day_order", nullable = false)
	private Integer dayOrder;

	@Column(name = "period_no", nullable = false)
	private Integer periodNo;

	@Column(name = "subject_id", nullable = false, length = 10)
	private String subjectId;

	@Column(name = "staff_id")
	private Long staffId;

	// Getters and Setters

	public Long getTimetableId() {
	    return timetableId;
	}

	public void setTimetableId(Long timetableId) {
	    this.timetableId = timetableId;
	}

	public Long getClassId() {
	    return classId;
	}

	public void setClassId(Long classId) {
	    this.classId = classId;
	}

	public Integer getDayOrder() {
	    return dayOrder;
	}

	public void setDayOrder(Integer dayOrder) {
	    this.dayOrder = dayOrder;
	}

	public Integer getPeriodNo() {
	    return periodNo;
	}

	public void setPeriodNo(Integer periodNo) {
	    this.periodNo = periodNo;
	}

	public String getSubjectId() {
	    return subjectId;
	}

	public void setSubjectId(String subjectId) {
	    this.subjectId = subjectId;
	}

	public Long getStaffId() {
	    return staffId;
	}

	public void setStaffId(Long staffId) {
	    this.staffId = staffId;
	}

}
