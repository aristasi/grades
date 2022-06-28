package com.uni.grades.converter;

import com.uni.grades.domain.Exam;
import com.uni.grades.domain.Lesson;
import com.uni.grades.dto.ExamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExamDtoToExam implements Converter<ExamDto, Exam> {

    @Override
    public Exam convert(ExamDto source) {
        return Exam.builder()
                .examId(source.getExamId())
                .examDate(source.getExamDate())
                .totalNumOfStudents(source.getTotalNumOfStudents())
                .succeedStudents(source.getSucceedStudents())
                .averageGrade(source.getAverageGrade())
                .build();
    }
}