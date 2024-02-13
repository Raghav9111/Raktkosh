package com.raktosh.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raktosh.entities.Donor;
import com.raktosh.entities.User;
@Repository
public interface DonorRepo extends JpaRepository<Donor, Integer> {
	Optional<Donor> findByUser(User user);
}
