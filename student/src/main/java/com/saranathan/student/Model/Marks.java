package com.saranathan.student.Model;



import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markId;

    private Long regNo;

    private int batchNo;


    private String subjectId;

    
    @Column(name = "ia1_marks")
    private int ia1Marks;
    
    @Column(name = "ia2_marks")
    private int ia2Marks;
    
    @Column(name = "ia3_marks")
    private int ia3Marks;


    @Column(name = "semester_grade")
    private  String semesterGrade;

    @Column(name = "exam_attempt")
    private String examAttempt;

    private int semesterNo;

    @Column(name = "last_updated", insertable = false, updatable = false)
    private Timestamp lastUpdated;


    // Getters and Setters
    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public int getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getIa1Marks() {
        return ia1Marks;
    }

    public void setIa1Marks(int ia1Marks) {
        this.ia1Marks = ia1Marks;
    }

    public int getIa2Marks() {
        return ia2Marks;
    }

    public void setIa2Marks(int ia2Marks) {
        this.ia2Marks = ia2Marks;
    }

    public int getIa3Marks() {
        return ia3Marks;
    }

    public void setIa3Marks(int ia3Marks) {
        this.ia3Marks = ia3Marks;
    }


    public String getSemesterGrade() {
        return semesterGrade;
    }

    public void setSemesterGrade(String semesterGrade) {
        this.semesterGrade = semesterGrade;
    }

    public String getExamAttempt() {
        return examAttempt;
    }

    public void setExamAttempt(String examAttempt) {
        this.examAttempt = examAttempt;
    }
    public int getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(int semesterNo) {
        this.semesterNo = semesterNo;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }
    
    public String toString() {
		return regNo + " " + batchNo +" "+subjectId+" "+ia1Marks+" "+ia2Marks+" "+ia3Marks;
    	
    }
}
