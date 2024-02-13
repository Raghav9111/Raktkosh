package com.raktosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raktosh.entities.Camp;
@Repository
public interface CampRepo extends JpaRepository<Camp, Integer> {

}
