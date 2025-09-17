package com.saranathan.student.DTOs;

import java.time.LocalDate;
import java.util.List;

public class TimetableDTO1 {
	
	private LocalDate currentDate;
	
	private int dayOrder;
	
	private String description;
	
	private List<TimetableDTO> dayOrderTimetable;

	public int getDayOrder() {
		return dayOrder;
	}

	public void setDayOrder(int dayOrder) {
		this.dayOrder = dayOrder;
	}

	public List<TimetableDTO> getDayOrderTimetable() {
		return dayOrderTimetable;
	}

	public void setDayOrderTimetable(List<TimetableDTO> list) {
		this.dayOrderTimetable = list;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
