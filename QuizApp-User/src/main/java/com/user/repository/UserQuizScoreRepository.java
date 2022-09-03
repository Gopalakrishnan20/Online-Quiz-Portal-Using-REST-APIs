package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.UserQuizScore;

public interface UserQuizScoreRepository extends JpaRepository<UserQuizScore, Long> {

}
