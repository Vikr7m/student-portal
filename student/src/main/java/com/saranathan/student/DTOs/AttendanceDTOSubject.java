package com.saranathan.student.DTOs;

import java.math.BigDecimal;

public class AttendanceDTOSubject {
    private String subjectId;
    private BigDecimal totalPresent;
    private BigDecimal totalAbsent;
    private Long totalPeriods;

    AttendanceDTOSubject(String subjectId, BigDecimal totalPresent, BigDecimal totalAbsent, Long totalPeriods) {
        this.subjectId = subjectId;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
        this.totalPeriods = totalPeriods;
    }

    public String getSubjectId() { return subjectId; }
    public BigDecimal getTotalPresent() { return totalPresent; }
    public BigDecimal getTotalAbsent() { return totalAbsent; }
    public Long getTotalPeriods() { return totalPeriods; }
}

class AttendanceDTOSubject1{
	
}
