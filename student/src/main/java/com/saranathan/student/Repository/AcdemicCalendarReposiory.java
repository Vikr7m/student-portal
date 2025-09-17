package com.saranathan.student.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.AcademicCalendar;

public interface AcdemicCalendarReposiory extends JpaRepository<AcademicCalendar, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT day_order FROM academic_calendar WHERE date = :dateToday")
	Integer findDayOrderByDate(@Param("dateToday") LocalDate dateToday);
	
	
	@Query(nativeQuery = true, value = "SELECT description FROM academic_calendar WHERE date = :date")
	String findDiscriptionByDate(@Param("date") LocalDate date);
}
