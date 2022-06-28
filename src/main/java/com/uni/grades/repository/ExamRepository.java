package com.uni.grades.repository;

import com.uni.grades.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    Exam findByExamDate(LocalDate examDate);
}
