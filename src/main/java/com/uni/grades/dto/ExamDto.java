package com.uni.grades.dto;

import com.uni.grades.domain.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamDto {
    private Long examId;
    private LocalDate examDate;
    private int totalNumOfStudents;
    private int succeedStudents;
    private BigDecimal averageGrade;
    private Long lessonId;
}