package com.uni.grades.service;

import com.uni.grades.domain.Exam;
import com.uni.grades.dto.ExamDto;

import java.time.LocalDate;
import java.util.List;

public interface ExamService {
    ExamDto save(ExamDto exam);
    List<ExamDto> findAll();
    ExamDto findByExamDate(LocalDate date);
    void deleteById(Long id);
}
