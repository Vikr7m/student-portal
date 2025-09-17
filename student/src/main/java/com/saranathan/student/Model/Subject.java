package com.saranathan.student.Model;

import com.saranathan.student.enums.EvaluationMethod;
import com.saranathan.student.enums.SubjectCategory;
import com.saranathan.student.enums.SubjectType;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@Getter
@Setter
public class Subject {

    @Id
    @Column(name = "subject_id", length = 10)
    private String subjectId;

    @Column(name = "subject_name", length = 100, nullable = false)
    private String subjectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_type", columnDefinition = "ENUM('Theory','Lab','Theory + Lab','Project') DEFAULT 'Theory'")
    private SubjectType subjectType = SubjectType.Theory;

    @Column(nullable = false)
    private int credits;

    @Column(name = "is_core")
    private Boolean isCore = true;

    @Column(name = "is_integrated")
    private Boolean isIntegrated = false;

    @Column(name = "lecture_hours_per_week")
    private Integer lectureHoursPerWeek = 0;

    @Column(name = "lab_hours_per_week")
    private Integer labHoursPerWeek = 0;

    @Column(name = "tutorial_hours_per_week")
    private Integer tutorialHoursPerWeek = 0;

    @Column(name = "max_marks")
    private Integer maxMarks = 100;

    @Column(name = "passing_marks")
    private Integer passingMarks = 50;

    @Enumerated(EnumType.STRING)
    @Column(name = "evaluation_method", columnDefinition = "ENUM('Internal','External','Both') DEFAULT 'Both'")
    private EvaluationMethod evaluationMethod = EvaluationMethod.Both;

    @Enumerated(EnumType.STRING)
    @Column(name = "subject_category", columnDefinition = "ENUM('Science','Engineering','Humanities','Management','Elective','Foundation') DEFAULT 'Engineering'")
    private SubjectCategory subjectCategory = SubjectCategory.Engineering;

    @Column(name = "regulation_code", length = 20)
    private String regulationCode;

    @Column(name = "syllabus_link", columnDefinition = "TEXT")
    private String syllabusLink;

    @Column(columnDefinition = "TEXT")
    private String prerequisites;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "class_id")
    private Long classId;
}

