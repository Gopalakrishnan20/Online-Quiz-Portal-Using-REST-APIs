package com.admin.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.model.QnA;

public interface QuestionRepository extends JpaRepository<QnA, Long> {
List<QnA> getByQzId(Long id);

}
