package com.uni.grades.service;

import com.uni.grades.converter.ExamDtoToExam;
import com.uni.grades.converter.ExamToExamDto;
import com.uni.grades.converter.LessonDtoToLesson;
import com.uni.grades.domain.Exam;
import com.uni.grades.dto.ExamDto;
import com.uni.grades.dto.LessonDto;
import com.uni.grades.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ExamDtoToExam examDtoToExamConverter;
    private final ExamToExamDto examToExamDtoConverter;
    private final LessonDtoToLesson lessonDtoToLessonConverter;
    private final LessonService lessonService;

    @Autowired
    public ExamServiceImpl(ExamRepository examRepository,
                           ExamDtoToExam examDtoToExamConverter,
                           ExamToExamDto examToExamDtoConverter, LessonDtoToLesson lessonDtoToLessonConverter, LessonService lessonService) {
        this.examRepository = examRepository;
        this.examDtoToExamConverter = examDtoToExamConverter;
        this.examToExamDtoConverter = examToExamDtoConverter;
        this.lessonDtoToLessonConverter = lessonDtoToLessonConverter;
        this.lessonService = lessonService;
    }

    @Override
    public ExamDto save(ExamDto examDto) {
        Exam convertedExam = examDtoToExamConverter.convert(examDto);
        LessonDto lessonRetrieved = lessonService.findById(examDto.getLessonId());
        convertedExam.setLesson(lessonDtoToLessonConverter.convert(lessonRetrieved));
        Exam saved = examRepository.save(convertedExam);
        return examToExamDtoConverter.convert(saved);
    }

    @Override
    public List<ExamDto> findAll() {
        return examRepository.findAll()
                .stream()
                .map(examToExamDtoConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ExamDto findByExamDate(LocalDate date) {
        Exam retrieved = examRepository.findByExamDate(date);
        return examToExamDtoConverter.convert(retrieved);
    }

    @Override
    public void deleteById(Long id) {
        examRepository.deleteById(id);
    }
}