package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM projects WHERE batch_no = :batchNo")
	List<Project> getProjectByBatchNo(Integer batchNo);
   
	
	
}