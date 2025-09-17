package com.saranathan.student.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.saranathan.student.Model.Certificate;


@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM certificates WHERE batch_no = :batchNo")
	List<Certificate> getCertificatesById(Integer batchNo);

}
