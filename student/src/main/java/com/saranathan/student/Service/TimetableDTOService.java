package com.saranathan.student.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.DTOs.TimetableDTO;
import com.saranathan.student.Model.Timetable;
import com.saranathan.student.Repository.AcdemicCalendarReposiory;
import com.saranathan.student.Repository.StaffRepository;
import com.saranathan.student.Repository.SubjectRepository;
import com.saranathan.student.Repository.TimetableRepository;

@Service
public class TimetableDTOService {
	
	@Autowired
	private TimetableRepository timetableRepo;
	
	
	@Autowired
	private AcdemicCalendarReposiory calendarRepository;
	
	@Autowired
	private SubjectRepository subjectRepo;
	
	@Autowired
	private StaffRepository staffRepo;
	
	
	
	public List<Timetable> getTimetableDetails(Long classId, Integer dayOrder){
		
		return timetableRepo.findByClassIdAndDayOrder(classId, dayOrder);
	}
	
	public TimetableDTO getTimetableDTO(Timetable timetable) {
		
		
		TimetableDTO timetableDTO = new TimetableDTO();
		
		timetableDTO.setPeriodNo(timetable.getPeriodNo());
		timetableDTO.setSubjectId(timetable.getSubjectId());
		timetableDTO.setSubjectName(subjectRepo.findSubNameBySubjectCode(timetable.getSubjectId()));
		timetableDTO.setStaffName(staffRepo.findStaffNamebyStaffId(timetable.getStaffId()));
		timetableDTO.setStartTime();
		timetableDTO.setEndTime();
		
		return timetableDTO;
	}
	
	public List<TimetableDTO> getTimetableDTODetails(Long classId, LocalDate currentDate){
		List<TimetableDTO> result = new ArrayList<>();
		
		//LocalDate currentDate = LocalDate.now();
		Integer dayOrder = calendarRepository.findDayOrderByDate(currentDate);
		
		if (dayOrder == null) {
			return result;
		}
		
		List<Timetable> timetables = getTimetableDetails(classId,dayOrder);
		
		for (Timetable i : timetables) {
			result.add(getTimetableDTO(i));
		}
		
		return result;
	}

}
