package com.uni.grades.repository;

import com.uni.grades.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Lesson findByTitle(String title);
    Optional<Lesson> findById(Long id);
}
