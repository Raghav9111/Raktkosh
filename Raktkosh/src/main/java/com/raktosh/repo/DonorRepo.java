package com.raktosh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raktosh.entities.Donor;
import com.raktosh.entities.User;

public interface DonorRepo extends JpaRepository<Donor, Integer> {
	Optional<Donor> findByUser(User user);
}
