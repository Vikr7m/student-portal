package com.saranathan.student.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Marks;
import com.saranathan.student.Model.Student;

@Repository
public interface StudentMarksRepository extends JpaRepository<Marks , Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM marks WHERE reg_no = :regNo AND subject_id = :subid")
	Optional<Marks> findByRegNo(@Param("regNo") Object regNo,@Param("subid") String subid);
	
	@Query(nativeQuery = true, value = "SELECT * FROM marks WHERE batch_no = :batchNo")
	Optional findById(Integer batchNo);
	
	@Query(nativeQuery = true, value = "SELECT * FROM marks WHERE batch_no = :batchNo  AND semester_no = :semesterNo")
	List<Marks> findBySem(int semesterNo, Integer batchNo);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM marks WHERE batch_no = :batchNo")
	int getTotalSubjectsCount(Integer batchNo);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM marks WHERE batch_no = :batchNo AND (semester_grade='U' OR semester_grade='RA')")
	int getSubjectsFailed(Integer batchNo);
	
	@Query(nativeQuery = true, value = "SELECT COUNT(*) FROM marks WHERE batch_no = :batchNo AND exam_attempt='Arrear'")
	int getArrearAttempts(Integer batchNo);
	
	

}
