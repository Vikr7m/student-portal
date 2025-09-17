package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saranathan.student.Model.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Integer>{
	
	List<Timetable> findByClassIdAndDayOrder(Long classId, Integer dayOrder);
}
