package com.raktosh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raktosh.entities.BloodBank;
import com.raktosh.entities.User;

public interface BloodBankRepo extends JpaRepository<BloodBank, Integer>{
	Optional<BloodBank> findByUser(User user);
}
