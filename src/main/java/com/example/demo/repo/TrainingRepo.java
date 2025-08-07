package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TrainingEntity;

@Repository
public interface TrainingRepo extends JpaRepository<TrainingEntity, Long>{

}
