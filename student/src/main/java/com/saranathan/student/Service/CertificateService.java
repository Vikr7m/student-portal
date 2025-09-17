package com.saranathan.student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saranathan.student.Model.Certificate;
import com.saranathan.student.Repository.CertificateRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CertificateService {
	
	@Autowired
	private CertificateRepository certificateRepo;
	
	public String addCertificate(Certificate certificate) {
		certificateRepo.save(certificate);
		return "Added Suceessfully";
	}
	
	public List<Certificate> getCertificate(Integer batchNo){
		//List<Certificate> result = new ArrayList<>();
		
		List<Certificate> result = certificateRepo.getCertificatesById(batchNo);
		
		return result;
	}

	public void deleteCertificate(int id) {
        if (!certificateRepo.existsById(id)) {
            throw new EntityNotFoundException("Certificate with id " + id + " not found");
        }
        certificateRepo.deleteById(id);
    }
}
