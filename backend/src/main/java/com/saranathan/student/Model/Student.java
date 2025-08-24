package com.saranathan.student.Model;


import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(name = "reg_no")
    private Long regNo;

    @Column(length = 100)
    private String name;

    @Column(name = "batch_no", unique = true)
    private Integer batchNo;

    @Column(length = 50)
    private String branch;

    @Column(length = 5)
    private String section;
    
    @Column(name="year")
    private Integer year;
    
    @Column(name = "semester")
    private Integer semester;

    @Column(name = "father_name", length = 100)
    private String fatherName;

    @Column(name = "father_occupation", length = 100)
    private String fatherOccupation;

    @Column(name = "mother_name", length = 100)
    private String motherName;

    @Column(name = "mother_occupation", length = 100)
    private String motherOccupation;

    @Column(name = "address" , columnDefinition = "TEXT")
    private String address;

    @Column(name = "sex", length = 10)
    private String sex;

    @Column(name = "program", length = 20)
    private String program;

    @Column(name = "nativity", length = 50)
    private String nativity;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(name= "community", length = 20)
    private String community;

    @Column(name = "religion", length = 50)
    private String religion;

    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    @Column(name="batch", length = 20)
    private String batch;

    @Column(name= "regulation", length = 20)
    private String regulation;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "college_email", length = 100)
    private String collegeEmail;

    @Column(name="password", length = 100)
    private String password;

    @Column(name = "personal_email", length = 100)
    private String personalEmail;
    
    @Column(name = "blood_group")
    private String bloodGroup;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    
    @Column(name = "emergency_contact")
    private String emergencyContact;
    
    @Lob
    private byte[] imageData;


	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return getCollegeEmail();
	}

	public void setPassword(String encode) {
		this.password = encode;
		
	}

	public String getCollegeEmail() {
		return collegeEmail;
	}

	public void setCollegeEmail(String collegeEmail) {
		this.collegeEmail = collegeEmail;
	}

	public void setUsername(String username) {
		this.collegeEmail = username;
		
	}

	public int getBatchNo() {
		return batchNo;
	}

	public String getBranch() {
		return branch;
	}

	public float getCgpa() {
		return 0;
	}

	public String getName() {
		return name;
	}

	public Object getRegNo() {
		return regNo;
	}

	public Long getClassId() {
		// TODO Auto-generated method stub
		return classId;
	}
	
	public String getProgram() {
		return program;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public String toString() {
		return batchNo + " " + regNo+" "+name+" "+collegeEmail;
	}

	public String getFatherName() {
		return fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getAddress() {
		return address;
	}

	public int getYear() {
		return year;
	}

	public int getSemester() {
		return semester;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

}
