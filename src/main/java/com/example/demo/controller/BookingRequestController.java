package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TrainingEntity;
import com.example.demo.serv.BookingRequestServ;
import com.example.demo.serv.TrainingServ;



@CrossOrigin(origins = "https://bweb-nu.vercel.app/")
	
@RequestMapping("/api")
@RestController
public class BookingRequestController {

	@Autowired
	private BookingRequestServ serv;
	
	@Autowired
	private TrainingServ tserv;
	
	@PostMapping("/booking")
	public BookingRequest save(@RequestBody BookingRequest booking) {
		return serv.save(booking);
	}
	
	
	@PostMapping("/training")
	public TrainingEntity save(@RequestBody TrainingEntity training) {
		return tserv.save(training);
	}
}
