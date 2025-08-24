package com.saranathan.student.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.Marks;
import com.saranathan.student.Model.Student;

public interface StudentMarksRepository extends JpaRepository<Marks , Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM marks WHERE reg_no = :regNo AND subject_id = :subid")
	Optional<Marks> findByRegNo(@Param("regNo") Object regNo,@Param("subid") String subid);
	

}
