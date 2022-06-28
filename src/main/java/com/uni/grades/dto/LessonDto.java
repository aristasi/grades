package com.uni.grades.dto;

import com.uni.grades.domain.Exam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LessonDto {
    private Long lessonId;
    private String title;
    private String semester;
    private List<Exam> exams;
}
