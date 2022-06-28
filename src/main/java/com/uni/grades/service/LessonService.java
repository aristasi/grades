package com.uni.grades.service;

import com.uni.grades.domain.Exam;
import com.uni.grades.domain.Lesson;
import com.uni.grades.dto.LessonDto;

import java.util.List;

public interface LessonService {
    LessonDto save(LessonDto lesson);
    List<LessonDto> findAll();
    LessonDto findByTitle(String title);
    void deleteById(Long id);
    LessonDto findById(Long lessonId);
}
