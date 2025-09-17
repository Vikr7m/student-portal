package com.saranathan.student.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "class_subject_map")
public class ClassSubjectMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "map_id")
    private int mapId;

    @Column(name = "batch_no", nullable = false)
    private int batchNo;

    @Column(name = "subject_id", nullable = false, length = 10)
    private String subjectId;

    @Column(name = "staff_id", nullable = false)
    private long staffId;

    @Column(name = "class_id", nullable = false)
    private long classId;

    // Constructors
    public ClassSubjectMap() {
    }

    public ClassSubjectMap(int batchNo, String subjectId, long staffId, long classId) {
        this.batchNo = batchNo;
        this.subjectId = subjectId;
        this.staffId = staffId;
        this.classId = classId;
    }

    // Getters and Setters
    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
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

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    // toString() - optional for debugging/logging
    @Override
    public String toString() {
        return "ClassSubjectMap{" +
                "mapId=" + mapId +
                ", batchNo=" + batchNo +
                ", subjectId='" + subjectId + '\'' +
                ", staffId=" + staffId +
                ", classId=" + classId +
                '}';
    }
}
