package com.saranathan.student.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "academic_calendar")
public class AcademicCalendar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "day", nullable = false, length = 10)
	private String day;

	@Column(name = "description", length = 255)
	private String description;

	@Column(name = "day_order")
	private Integer dayOrder;

	@Column(name = "working_day_number")
	private Integer workingDayNumber;

	// Getters and Setters

	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}

	public LocalDate getDate() {
	    return date;
	}

	public void setDate(LocalDate date) {
	    this.date = date;
	}

	public String getDay() {
	    return day;
	}

	public void setDay(String day) {
	    this.day = day;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

	public Integer getDayOrder() {
	    return dayOrder;
	}

	public void setDayOrder(Integer dayOrder) {
	    this.dayOrder = dayOrder;
	}

	public Integer getWorkingDayNumber() {
	    return workingDayNumber;
	}

	public void setWorkingDayNumber(Integer workingDayNumber) {
	    this.workingDayNumber = workingDayNumber;
	}


}
