package com.saranathan.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.saranathan.student.Model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT name FROM staffs WHERE staff_id = :staffId")
	String findStaffNamebyStaffId(@Param("staffId") long staffId);

}
