package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TrainingEntity;
import com.example.demo.repo.TrainingRepo;

@Service
public class TrainingServ {

	@Autowired
	private TrainingRepo repo;
	
	public TrainingEntity save(TrainingEntity train) {
		return repo.save(train);
	}
	
	public List<TrainingEntity> getAllTrainings() {
        return repo.findAll();
    }
}
