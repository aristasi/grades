package com.uni.grades.service;

import com.uni.grades.converter.LessonDtoToLesson;
import com.uni.grades.converter.LessonToLessonDto;
import com.uni.grades.domain.Lesson;
import com.uni.grades.dto.LessonDto;
import com.uni.grades.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonDtoToLesson lessonDtoToLessonConverter;
    private final LessonToLessonDto lessonToLessonDtoConverter;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository,
                             LessonDtoToLesson lessonDtoToLessonConverter,
                             LessonToLessonDto lessonToLessonDtoConverter) {
        this.lessonRepository = lessonRepository;
        this.lessonDtoToLessonConverter = lessonDtoToLessonConverter;
        this.lessonToLessonDtoConverter = lessonToLessonDtoConverter;
    }

    @Override
    public LessonDto save(LessonDto lesson) {
        Lesson convertedLesson = lessonDtoToLessonConverter.convert(lesson);
        Lesson saved = lessonRepository.save(convertedLesson);
        return lessonToLessonDtoConverter.convert(saved);
    }

    @Override
    public List<LessonDto> findAll() {
        return lessonRepository.findAll()
                .stream()
                .map(lessonToLessonDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public LessonDto findByTitle(String title) {
        Lesson retrieved = lessonRepository.findByTitle(title);
        return lessonToLessonDtoConverter.convert(retrieved);
    }

    @Override
    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public LessonDto findById(Long lessonId) {
        return lessonRepository.findById(lessonId)
                .map(lessonToLessonDtoConverter::convert)
                .orElse(null);
    }
}