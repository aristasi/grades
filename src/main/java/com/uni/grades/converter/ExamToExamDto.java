package com.uni.grades.converter;

import com.uni.grades.domain.Exam;
import com.uni.grades.dto.ExamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExamToExamDto implements Converter<Exam, ExamDto> {

    @Override
    public ExamDto convert(Exam source) {
        return ExamDto.builder()
                .examId(source.getExamId())
                .examDate(source.getExamDate())
                .totalNumOfStudents(source.getTotalNumOfStudents())
                .succeedStudents(source.getSucceedStudents())
                .averageGrade(source.getAverageGrade())
                .lessonId(getLessonId(source))
                .build();
    }

    private Long getLessonId(Exam source) {
        if (source.getLesson() != null) {
            return source.getLesson().getLessonId();
        }
        return null;
    }
}
