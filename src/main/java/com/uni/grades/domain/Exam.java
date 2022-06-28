package com.uni.grades.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "EXAMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {
    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    @Column(name = "exam_date")
    private LocalDate examDate;
    @Column(name = "total_students")
    private int totalNumOfStudents;
    @Column(name = "succeed_students")
    private int succeedStudents;
    @Column(name = "average_grade")
    private BigDecimal averageGrade;
    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}
