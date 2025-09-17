package com.saranathan.student.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="attendance")
public class Attendance {
	
	@Id
    private int attendanceId;
    private Integer batchNo;
    private java.sql.Date attendanceDate;
    private int periodNo;
    private String status; // 'Present', 'Absent', 'Late', 'Leave'
    private java.sql.Timestamp createdAt;

    // Default constructor
    public Attendance() {
    }

    // Parameterized constructor
    public Attendance(int attendanceId, Integer batchNo, java.sql.Date attendanceDate,
                      int periodNo, String status, java.sql.Timestamp createdAt) {
        this.attendanceId = attendanceId;
        this.batchNo = batchNo;
        this.attendanceDate = attendanceDate;
        this.periodNo = periodNo;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public java.sql.Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(java.sql.Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public int getPeriodNo() {
        return periodNo;
    }

    public void setPeriodNo(int periodNo) {
        this.periodNo = periodNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    // toString for debugging/logging
    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", batchNo='" + batchNo + '\'' +
                ", attendanceDate=" + attendanceDate +
                ", periodNo=" + periodNo +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

