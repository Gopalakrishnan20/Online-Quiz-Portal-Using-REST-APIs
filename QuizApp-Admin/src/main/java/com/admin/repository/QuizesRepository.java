package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.Quizes;

public interface QuizesRepository extends JpaRepository<Quizes, Long> {

	List<Quizes> findAllByPublished(boolean b);

}
