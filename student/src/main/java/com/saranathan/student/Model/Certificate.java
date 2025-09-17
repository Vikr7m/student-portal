package com.saranathan.student.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table ( name = "certificates")
public class Certificate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String issuedOrganization;
    private Date issueDate;
    private String type;  
    private byte[] certificateFile; 
    private Integer batchNo; 


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssuedOrganization() {
        return issuedOrganization;
    }

    public void setIssuedOrganization(String issuedOrganization) {
        this.issuedOrganization = issuedOrganization;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getCertificateFile() {
        return certificateFile;
    }

    public void setCertificateFile(byte[] certificateFile) {
        this.certificateFile = certificateFile;
    }

	public Integer getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(Integer batchNo) {
		this.batchNo = batchNo;
	}
}

