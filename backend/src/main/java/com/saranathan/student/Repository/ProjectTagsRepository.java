package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.ProjectTags;

@Repository
public interface ProjectTagsRepository extends JpaRepository<ProjectTags, Integer>{

}
