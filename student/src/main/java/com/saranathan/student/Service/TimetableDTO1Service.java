package com.saranathan.student.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.TimetableDTO;
import com.saranathan.student.DTOs.TimetableDTO1;
import com.saranathan.student.Model.Student;
import com.saranathan.student.Repository.AcdemicCalendarReposiory;
import com.saranathan.student.Repository.StudentRepository;

@Service
public class TimetableDTO1Service {
	
	@Autowired
	private AcdemicCalendarReposiory calendarRepository;
	
	@Autowired
	private TimetableDTOService timetableDTO;
	
	@Autowired
	private StudentRepository repo;
	
	
	public TimetableDTO1 getTimetableDTO1Details(LocalDate date, String email) {
		TimetableDTO1 result = new TimetableDTO1();
		
		Student student = repo.findByEmail(email).orElse(null);
		Long classId = student.getClassId();
		Integer dayOrder = calendarRepository.findDayOrderByDate(date);
		String description = calendarRepository.findDiscriptionByDate(date);
		
		result.setCurrentDate(date);
		result.setDescription(description);
		
		if (dayOrder == null) {
			return result;
		}
		
		result.setDayOrder(dayOrder);
		result.setDayOrderTimetable(timetableDTO.getTimetableDTODetails(classId, date));
		
		
		return result;
		
	}


}
