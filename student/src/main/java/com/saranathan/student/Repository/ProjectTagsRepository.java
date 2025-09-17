package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.ProjectTags;

@Repository
public interface ProjectTagsRepository extends JpaRepository<ProjectTags, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT tagid FROM project_tags WHERE projectid = :projectId")
	List<Integer> getTagdIdsByProjectId(int projectId);

}
