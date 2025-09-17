package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saranathan.student.DTOs.AttendanceDTOSubject;
import com.saranathan.student.Model.Attendance;


@Repository
public interface AttendanceRepository extends JpaRepository <Attendance, Integer>{
	
	
	@Query(nativeQuery = true, value = "SELECT t.subject_id, SUM(CASE WHEN a.status = 'Present' THEN 1 ELSE 0 END) AS total_present, SUM(CASE WHEN a.status = 'Absent' THEN 1 ELSE 0 END) AS total_absent, COUNT(*) AS total_periods FROM attendance a JOIN students s ON a.batch_no = s.batch_no JOIN academic_calendar ac ON a.attendance_date = ac.date JOIN class_timetable t ON s.class_id = t.class_id AND ac.day_order = t.day_order AND a.period_no = t.period_no WHERE a.batch_no = :batchNo GROUP BY t.subject_id")
	List<AttendanceDTOSubject> getStudentAttendanceBybatchNo(Integer batchNo);


}
