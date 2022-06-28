package com.uni.grades.converter;

import com.uni.grades.domain.Lesson;
import com.uni.grades.dto.LessonDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class LessonToLessonDto implements Converter<Lesson, LessonDto> {

    @Override
    public LessonDto convert(Lesson source) {
        return LessonDto.builder()
                .lessonId(source.getLessonId())
                .title(source.getTitle())
                .semester(source.getSemester())
                .exams(Optional.ofNullable(source.getExams()).orElse(new ArrayList<>()))
                .build();
    }
}
