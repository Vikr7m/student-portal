package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.ClassSubjectMap;

public interface SubjectMappingRepository extends JpaRepository<ClassSubjectMap, Integer>{

	@Query(value = "SELECT * FROM class_subject_map WHERE batch_no = :batchNo", nativeQuery = true)
	List<ClassSubjectMap> findByBatchNo(@Param("batchNo") int batchNo);


}
