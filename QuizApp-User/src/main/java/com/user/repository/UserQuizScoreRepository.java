package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.UserQuizScore;

public interface UserQuizScoreRepository extends JpaRepository<UserQuizScore, Long> {

	List<UserQuizScore> findByQzId(long qzId);

}
