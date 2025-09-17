package com.saranathan.student.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	

	@Query(nativeQuery = true, value = "SELECT * FROM students WHERE college_email = :email")
	Optional<Student> findByEmail(@Param("email") String email);
	
	@Query(nativeQuery = true, value = "SELECT * FROM students WHERE batch_no = :batchNo")
	Optional<Student> findByBatchNo(Integer batchNo);

	
	@Query(nativeQuery = true, value = "UPDATE students SET image_data = :imageData WHERE batch_no = :id")
	void setStudentImage(Integer id, byte[] imageData);
	
	@Query(nativeQuery = true, value = "SELECT semester FROM students WHERE  batch_no = :batchNo")
	int getSemByBatchNo(Integer batchNo);


}
