package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

	UserDetails getByUserName(String uname);


}
