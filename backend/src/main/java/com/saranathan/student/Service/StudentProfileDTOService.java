package com.saranathan.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.StudentProfileDTO;
import com.saranathan.student.Model.Student;
import com.saranathan.student.Repository.StudentRepository;

@Service
public class StudentProfileDTOService {
	
	@Autowired
	private StudentRepository repo;
	
	public StudentProfileDTO getStudentProfileDTODetails(String email) {
		
		Student student = repo.findByEmail(email).orElse(null);

		
		StudentProfileDTO result = new StudentProfileDTO();
		
		result.setName(student.getName());	
		result.setDept(student.getBranch());
		result.setBatchNo(student.getBatchNo());
		result.setAcademicYear(student.getProgram());
		result.setYear(student.getYear());
		result.setSemester(student.getSemester());
		result.setCgpa(student.getCgpa());
		result.setMobileNo(student.getPhoneNo());
		result.setEmail(email);
		result.setDob(student.getDateOfBirth());
		result.setBloodGroup(student.getBloodGroup());
		result.setFatherName(student.getFatherName());
		result.setMotherName(student.getMotherName());
		result.setAddress(student.getAddress());
		result.setEmergencyContact(student.getPhoneNo());
		
		return result;
		
	}

}
