package com.saranathan.student.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.StudentProfileDTO;
import com.saranathan.student.DTOs.StudentProjectDTO;
import com.saranathan.student.Model.Certificate;
import com.saranathan.student.Model.Student;
import com.saranathan.student.Repository.StudentRepository;

@Service
public class StudentProfileDTOService {
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private ProjectDTOService projectDTOService;
	
	@Autowired
	private CertificateService certificateService;
	
	public StudentProfileDTO getStudentProfileDTODetails(String email) {
		
		Student student = repo.findByEmail(email).orElse(null);

		
		StudentProfileDTO result = new StudentProfileDTO();
		
		result.setName(student.getName());	
		result.setDept(student.getBranch());
		result.setBatchNo(student.getBatchNo());
		result.setImage(student.getImageData());
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
		result.setCertificates(certificateService.getCertificate(student.getBatchNo()));
		result.setProjects(projectDTOService.getProjectDTODetails(student.getBatchNo()));
		
		return result;
		
	}

}
