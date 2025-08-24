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

    private String studentName;

    private String subjectId;

    private String subjectName;
    
    @Column(name = "ia1_marks")
    private int ia1Marks;
    
    @Column(name = "ia2_marks")
    private int ia2Marks;
    
    @Column(name = "ia3_marks")
    private int ia3Marks;

    // This field is stored/generated in DB, so it can be read-only
    @Column(insertable = false, updatable = false)
    private Integer averageInternalMarks;

    @Enumerated(EnumType.STRING)
    private SemesterGrade semesterGrade = SemesterGrade.U;

    @Enumerated(EnumType.STRING)
    private ExamAttempt examAttempt = ExamAttempt.Regular;

    private boolean isPassed;

    private Long classId;

    private String regulation;

    private String academicYear;

    private int semesterNo;

    @Column(name = "last_updated", insertable = false, updatable = false)
    private Timestamp lastUpdated;

    // Enum for semester grades
    public enum SemesterGrade {
        O, A_PLUS, A, B_PLUS, B, C, U, RA, AB
    }

    // Enum for exam attempt type
    public enum ExamAttempt {
        Regular, Arrear
    }

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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public Integer getAverageInternalMarks() {
        return averageInternalMarks;
    }

    public SemesterGrade getSemesterGrade() {
        return semesterGrade;
    }

    public void setSemesterGrade(SemesterGrade semesterGrade) {
        this.semesterGrade = semesterGrade;
    }

    public ExamAttempt getExamAttempt() {
        return examAttempt;
    }

    public void setExamAttempt(ExamAttempt examAttempt) {
        this.examAttempt = examAttempt;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
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
		return regNo + " " + batchNo +" "+subjectId+" "+subjectName+" "+ia1Marks+" "+ia2Marks+" "+ia3Marks;
    	
    }
}
