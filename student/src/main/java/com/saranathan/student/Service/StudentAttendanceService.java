package com.saranathan.student.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.AttendanceDTO;
import com.saranathan.student.DTOs.AttendanceDTOPerSubject;
import com.saranathan.student.DTOs.AttendanceDTOSubject;
import com.saranathan.student.Repository.AttendanceRepository;
import com.saranathan.student.Repository.SubjectRepository;

@Service
public class StudentAttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<AttendanceDTOSubject> getStudentAttendanceSubject(Integer batchNo){
		List<AttendanceDTOSubject> result = attendanceRepository.getStudentAttendanceBybatchNo(batchNo);
		System.out.println(result);
		return result;
	}
	
	public List<AttendanceDTOPerSubject> getAttendanceDetailsPerSubject(Integer batchNo){
		List<AttendanceDTOSubject> subjects = attendanceRepository.getStudentAttendanceBybatchNo(batchNo);
		List<AttendanceDTOPerSubject> result = new ArrayList<AttendanceDTOPerSubject>();
		for (AttendanceDTOSubject subject : subjects) {
			AttendanceDTOPerSubject currentSubject = new AttendanceDTOPerSubject();
			currentSubject.setSubjectId(subject.getSubjectId());
			currentSubject.setSubjectName(subjectRepository.findSubNameBySubjectCode(subject.getSubjectId()));
			currentSubject.setTotalAbsent(subject.getTotalAbsent());
			currentSubject.setTotalPresent(subject.getTotalPresent());
			currentSubject.setTotalPeriods(subject.getTotalPeriods());
			result.add(currentSubject);
		}
		return result;
	}
	
	//public AttendanceDTO getAttendanceDTODetails(Integer batchNo) {
	//	AttendanceDTO result = new AttendanceDTO();
	//	List<AttendanceDTOSubject> attendancePerSubject = attendanceRepository.getStudentAttendanceBybatchNo(batchNo);
	//	BigDecimal totalHours = BigDecimal.ZERO, totalPresent = BigDecimal.ZERO, totalAbsent = BigDecimal.ZERO;
		
	//	for (AttendanceDTOSubject subject : attendancePerSubject ) {
	//		totalHours = totalHours.add(subject.getTotalPeriods());
	//		totalPresent = totalHours.add(subject.getTotalPresent());
	//		totalAbsent =  totalHours.add(subject.getTotalAbsent());
	//	}
	//	BigDecimal attendancePercent = totalPresent
    //            .divide(totalHours, 2, RoundingMode.HALF_UP) // divide with scale and rounding
    //            .multiply(BigDecimal.valueOf(100));
	//	result.setAttendancePercentage(attendancePercent);
	//	result.setTotalHours(totalHours);
	//	result.setTotalPresent(totalPresent);
	//	result.setTotalAbsent(totalAbsent);
	//	result.setAttendancePerSubject(attendancePerSubject);
	//	return result;
//	}
	
	
}
