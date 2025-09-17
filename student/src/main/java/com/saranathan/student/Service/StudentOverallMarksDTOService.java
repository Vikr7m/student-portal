package com.saranathan.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.OverallMarksDTO;

@Service
public class StudentOverallMarksDTOService {
	
	@Autowired
	private StudentMarksService studentMarksService;
	
	public OverallMarksDTO getOverallMarksDTODetails(Integer batchNo) {
		OverallMarksDTO result = new OverallMarksDTO();
		
		result.setCgpa(studentMarksService.calculateCgpa(batchNo));
		result.setTotalSubjects(studentMarksService.getTotalSubjects(batchNo));
		result.setSubjectsPassed(studentMarksService.getTotalSubjects(batchNo) - studentMarksService.getSubjectsFailed(batchNo));
		result.setCurrentArrears((studentMarksService.getSubjectsFailed(batchNo)));
		result.setHistoryOfArrears(studentMarksService.historyOfArrears(batchNo));
		return result;
	}
}
