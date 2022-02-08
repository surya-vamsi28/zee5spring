package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.dto.Register;
@Repository
public interface UserRepository extends JpaRepository<Register, Integer> {
	Boolean existsByEmail(String email);
	Boolean existsByEmailAndPassword(String email,String password);
}
