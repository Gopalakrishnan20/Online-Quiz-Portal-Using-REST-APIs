package com.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.AdminDetails;
@Repository
public interface AdminRepo extends JpaRepository<AdminDetails, Long> {

	AdminDetails findByaUname(String uname);

}
