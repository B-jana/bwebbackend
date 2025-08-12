package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BookingRequest;
import com.example.demo.entity.TrainingEntity;
import com.example.demo.serv.BookingRequestServ;
import com.example.demo.serv.TrainingServ;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestMethod;




@CrossOrigin(origins = "https://bweb-ten.vercel.app",
	    allowedHeaders = "*",
    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
    allowCredentials = "true"
	    )
	
@RequestMapping("/api")
@RestController
public class BookingRequestController {

@Autowired
	private BookingRequestServ serv;
	
	@Autowired
	private TrainingServ tserv;
	
	private static final String ADMIN_USERNAME = "jaan";
    private static final String ADMIN_PASSWORD = "123";
	
    @PostMapping("/login")
    public ResponseEntity<?> adminLogin(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return ResponseEntity.ok(Map.of("message", "Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

	
	@PostMapping("/booking")
	public BookingRequest save(@RequestBody BookingRequest booking) {
		return serv.save(booking);
	}
	
	
	@PostMapping("/training")
	public TrainingEntity save(@RequestBody TrainingEntity training) {
		return tserv.save(training);
	}
	
	
	@GetMapping("/bookings")
    public List<BookingRequest> getAllBookings() {
        return serv.getAllBookings();
    }

    
    @GetMapping("/trainings")
    public List<TrainingEntity> getAllTrainings() {
        return tserv.getAllTrainings();
    }


	 @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Long id) {
    	serv.deleteBooking(id);
    }
    
    
    @DeleteMapping("/trainings/{id}")
    public void deleteTraining(@PathVariable Long id) {
    	tserv.deleteTraining(id);
    }
}
