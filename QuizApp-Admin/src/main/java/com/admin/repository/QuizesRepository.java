package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Quizes;

public interface QuizesRepository extends JpaRepository<Quizes, Long> {

}
