package com.saranathan.student.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.StudentDashboardDTO;
import com.saranathan.student.Model.ClassSubjectMap;
import com.saranathan.student.Model.Marks;
import com.saranathan.student.Model.Student;
import com.saranathan.student.Model.Timetable;
import com.saranathan.student.Repository.AcdemicCalendarReposiory;
import com.saranathan.student.Repository.StaffRepository;
import com.saranathan.student.Repository.StudentMarksRepository;
import com.saranathan.student.Repository.StudentRepository;
import com.saranathan.student.Repository.SubjectMappingRepository;
import com.saranathan.student.Repository.SubjectRepository;
import com.saranathan.student.Repository.TimetableRepository;

@Service
public class StudentDashboardDTOService {
	
	@Autowired
	private StudentRepository repo;
	
	@Autowired
	private StudentMarksRepository marksRepo;
	
	@Autowired
	private SubjectMappingRepository mappingRepo;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private StaffRepository staffRepo;
	
	@Autowired
	private AcdemicCalendarReposiory calendarRepository;
	
	@Autowired
	private TimetableDTOService timetableDTO1Service;
	
	@Autowired
	private SubjectStaffDTOService subjectStaffDTOService;
	
	@Autowired
	private StudentMarksService studentMarksService;
	
	public StudentDashboardDTO getStudentDashboardDetails(String email) {
		Student student = repo.findByEmail(email).orElse(null);
		System.out.println(student);
		String subid = "EC104";
		Marks mark = marksRepo.findByRegNo(student.getRegNo(), subid).orElse(null);
		System.out.println(mark);
		LocalDate currentDate = LocalDate.now();
		Integer dayOrder = calendarRepository.findDayOrderByDate(currentDate);
		StudentDashboardDTO studentDashboardDetails = new StudentDashboardDTO();
		studentDashboardDetails.setName(student.getName());
		studentDashboardDetails.setBatchNo(student.getBatchNo());
		studentDashboardDetails.setCgpa(studentMarksService.calculateCgpa(student.getBatchNo()));
		studentDashboardDetails.setDepartment(student.getBranch());
		studentDashboardDetails.setSubjectStaffs(subjectStaffDTOService.getSubjectsStaffsDetails(student.getBatchNo()));
		if (mark == null) {
			return studentDashboardDetails;
		}
		studentDashboardDetails.setIa1(mark.getIa1Marks());
		studentDashboardDetails.setIa2(mark.getIa2Marks());
		studentDashboardDetails.setIa3(mark.getIa3Marks());
		//studentDashboardDetails.setTimetable(getTimetableDetails(student.getClassId(), dayOrder));
		//studentDashboardDetails.setDayOrder(dayOrder);
		//studentDashboardDetails.setTimetable(timetableDTO1Service.getTimetableDTODetails(student.getClassId()));
		return studentDashboardDetails;
	}
	
	public List<List<String>> getSubjectsStaffsDetails(int batchNo){
		
		List<List<String>> result = new ArrayList<>();
		
		List<ClassSubjectMap> rows  = mappingRepo.findByBatchNo(batchNo);
		
		for (ClassSubjectMap i : rows) {
			List<String> pair = new ArrayList<>();
			pair.add(i.getSubjectId());			
			String subName = subjectRepo.findSubNameBySubjectCode(i.getSubjectId());
			pair.add(subName);
			String staffName = staffRepo.findStaffNamebyStaffId(i.getStaffId());
			pair.add(staffName);
			result.add(pair);
		}
		return result;
		
	}
	
	public byte[] getImageData(Integer batchNo) {
		Student student = repo.findByBatchNo(batchNo).orElse(null);
		
		return student.getImageData();
	}

	public void updateStudentImage(Integer id, byte[] imageData) {
		Student student = repo.findByBatchNo(id).orElse(null);
		student.setImageData(imageData);
		repo.save(student);
		
		
	}
	
	/**public List<Timetable> getTimetableDetails(Long classId, Integer dayOrder){
		
		return timetableRepo.findByClassIdAndDayOrder(classId, dayOrder);
	}
	**/
	

}
