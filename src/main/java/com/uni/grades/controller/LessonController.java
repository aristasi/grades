package com.uni.grades.controller;

import com.uni.grades.converter.LessonDtoToLesson;
import com.uni.grades.domain.Lesson;
import com.uni.grades.dto.LessonDto;
import com.uni.grades.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final LessonDtoToLesson lessonDtoToLessonConverter;


    @Autowired
    public LessonController(LessonService lessonService, LessonDtoToLesson lessonDtoToLessonConverter) {
        this.lessonService = lessonService;
        this.lessonDtoToLessonConverter = lessonDtoToLessonConverter;
    }

    @PostMapping("/insert")
    public LessonDto insert(@RequestBody LessonDto lesson) {
        Lesson convertedLesson = lessonDtoToLessonConverter.convert(lesson);
        lesson.getExams().forEach(exam -> exam.setLesson(convertedLesson));
        return lessonService.save(lesson);
    }

    @GetMapping()
    public List<LessonDto> findAll() {
        return lessonService.findAll();
    }

    @GetMapping("{title}")
    public LessonDto findByTitle(@PathVariable String title) {
        return lessonService.findByTitle(title);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        lessonService.deleteById(id);
    }
}