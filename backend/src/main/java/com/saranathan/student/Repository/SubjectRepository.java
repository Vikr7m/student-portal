package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	@Query(nativeQuery = true, value = "SELECT subject_name FROM subjects WHERE subject_id = :subjectId")
	String findSubNameBySubjectCode(@Param("subjectId") String subjectId);

}
