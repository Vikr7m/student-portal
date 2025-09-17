package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String>{

	@Query(nativeQuery = true, value = "SELECT subject_name FROM subjects WHERE subject_id = :subjectId")
	String findSubNameBySubjectCode(@Param("subjectId") String subjectId);
	
	@Query(nativeQuery = true, value = "SELECT credits FROM subjects  WHERE subject_id = :subjectId")
    int findCreditsBySubjectId(@Param("subjectId") String subjectId);

}
