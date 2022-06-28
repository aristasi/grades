package com.uni.grades.controller;

import com.uni.grades.dto.ExamDto;
import com.uni.grades.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/insert")
    public ExamDto insert(@RequestBody ExamDto exam) {
        return examService.save(exam);
    }

    @GetMapping
    public List<ExamDto> findAll() {
        return examService.findAll();
    }

    @GetMapping("{date}")
    public ExamDto findByExamDate(@PathVariable String date) {
        LocalDate examDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        return examService.findByExamDate(examDate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        examService.deleteById(id);
    }
}
