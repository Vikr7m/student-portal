package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // you can add custom queries if needed
}