package com.example.demo.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BookingRequest;
import com.example.demo.repo.BookingRequestRepo;

@Service
public class BookingRequestServ {

	@Autowired
	private BookingRequestRepo repo;
	
	
	public BookingRequest save(BookingRequest booking) {
		return repo.save(booking);
	}
}
