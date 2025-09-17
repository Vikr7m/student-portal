package com.saranathan.student.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "staffs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @Column(name = "staff_id")
    private Long staffId;

    @Column(length = 100)
    private String name;

    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String position;

    @Column(length = 100)
    private String qualification;

    private LocalDate dob;

    @Enumerated(EnumType.STRING)
    private Gender sex;

    @Column(length = 100)
    private String email;

    @Column(name = "phone_no", length = 15)
    private String phoneNo;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(length = 100)
    private String specialization;

    @Column(name = "blood_group", length = 10)
    private String bloodGroup;

    @Column(name = "class_id", length = 20)
    private String classId;

    @Column(name = "subjects_handled", columnDefinition = "TEXT")
    private String subjectsHandled;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public enum Gender {
        Male, Female, Other
    }
    
    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}

