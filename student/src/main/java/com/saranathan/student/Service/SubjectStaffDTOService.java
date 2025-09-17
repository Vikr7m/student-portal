package com.saranathan.student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.SubjectStaffDTO;
import com.saranathan.student.Model.ClassSubjectMap;
import com.saranathan.student.Repository.StaffRepository;
import com.saranathan.student.Repository.SubjectMappingRepository;
import com.saranathan.student.Repository.SubjectRepository;


@Service
public class SubjectStaffDTOService {
	
	@Autowired
	private SubjectMappingRepository mappingRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private StaffRepository staffRepo;
	
	
	
	
public List<SubjectStaffDTO> getSubjectsStaffsDetails(int batchNo){
	
	List<SubjectStaffDTO> result = new ArrayList<>();
	
	List<ClassSubjectMap> rows  = mappingRepo.findByBatchNo(batchNo);
	
	for (ClassSubjectMap i : rows) {
		SubjectStaffDTO row = new SubjectStaffDTO();
		row.setSubjectId(i.getSubjectId());
		row.setStaffName(staffRepo.findStaffNamebyStaffId(i.getStaffId()));
		row.setSubjectName(subjectRepo.findSubNameBySubjectCode(i.getSubjectId()));
		result.add(row);
	}
	
	
	return result;
		
	}

}
