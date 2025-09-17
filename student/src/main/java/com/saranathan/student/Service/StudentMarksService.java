package com.saranathan.student.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.MarksPerSem;
import com.saranathan.student.DTOs.MarksPerSemDTO;
import com.saranathan.student.Model.Marks;
import com.saranathan.student.Repository.StudentMarksRepository;
import com.saranathan.student.Repository.StudentRepository;
import com.saranathan.student.Repository.SubjectRepository;

@Service
public class StudentMarksService {
	
	@Autowired
	private StudentMarksRepository marksRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private StudentRepository studentRepo;
	
	
	public Optional getMarksDetails(Integer batchNo) {
		Optional marksDetails = marksRepo.findById(batchNo);
		return marksDetails;
	}
	
	private static final Map<String, Integer> gradePointMap = new HashMap<>();
    static {
        gradePointMap.put("O", 10);
        gradePointMap.put("A+", 9);
        gradePointMap.put("A", 8);
        gradePointMap.put("B+", 7);
        gradePointMap.put("B", 6);
        gradePointMap.put("C", 5);
        gradePointMap.put("U", 0);
        gradePointMap.put("RA", 0);
        gradePointMap.put("AB", 0);
    }
	
	public double calculateGpa(Map<String, Integer> gradeCredits) {
		double totalCredits = 0;
        double weightedPoints = 0;
		for (Map.Entry<String, Integer> entry : gradeCredits.entrySet()) {
			int gradePoint = gradePointMap.getOrDefault(entry.getKey(), 0);
			weightedPoints += gradePoint * entry.getValue();
            totalCredits += entry.getValue();
		}
		if (totalCredits == 0) return 0.0;

        return Math.round((weightedPoints / totalCredits) * 100.0) / 100.0;
	}
	
	public double calculateGpabySem(int semesterNo, Integer batchNo) {
		double totalCredits = 0;
        double weightedPoints = 0;
		List<Marks> marksDetails = marksRepo.findBySem(semesterNo,batchNo);
		for (Marks marks : marksDetails) {
			String grade = marks.getSemesterGrade();
			String subjectId = marks.getSubjectId();

			
            int credits = subjectRepo.findCreditsBySubjectId(subjectId);
			int gradePoint = gradePointMap.getOrDefault(grade, 0);
			
			weightedPoints += gradePoint * credits;
            totalCredits += credits;
            
		}
		if (totalCredits == 0) return 0.0;
        
        return weightedPoints / totalCredits;
	}
	
	public double calculateCgpa(Integer batchNo) {
		double result = 0.0;
		
		int sem = studentRepo.getSemByBatchNo(batchNo);
		for (int i = 1 ; i<=sem ; i++) {
			result += calculateGpabySem(i,batchNo);
		}
		
		return result/(sem-1);
	}
	
	public int getTotalSubjects(Integer batchNo) {
		return marksRepo.getTotalSubjectsCount(batchNo);
	}
	
	public int getSubjectsFailed(Integer batchNo) {
		return marksRepo.getSubjectsFailed(batchNo);
	}
	
	public int historyOfArrears(Integer batchNo) {
		int currentArrears = getSubjectsFailed(batchNo);
		int arrearAttempts = marksRepo.getArrearAttempts(batchNo);
		return currentArrears + arrearAttempts;
	}
	
	public MarksPerSemDTO getStudentMarksPerSemDetails(int sem, Integer batchNo) {
		MarksPerSemDTO result = new MarksPerSemDTO();
		List<Marks> marksDetails = marksRepo.findBySem(sem, batchNo);
		List<MarksPerSem> marksPerSem = new ArrayList();
		for (Marks marks : marksDetails) {
			MarksPerSem m = new MarksPerSem();
			m.setSubjectId(marks.getSubjectId());
			m.setSubjectName(subjectRepo.findSubNameBySubjectCode(marks.getSubjectId()));
			m.setIa1Marks(marks.getIa1Marks());
			m.setIa2Marks(marks.getIa2Marks());
			m.setIa3Marks(marks.getIa3Marks());
			m.setSemGrade(marks.getSemesterGrade());
			marksPerSem.add(m);
		}
		result.setMarksPerSem(marksPerSem);
		result.setGpa(calculateGpabySem(sem, batchNo));
		return result;
	}
	
}
