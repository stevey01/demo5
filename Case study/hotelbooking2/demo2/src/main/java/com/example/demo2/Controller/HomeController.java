package com.example.demo2.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.Repository.HmsRepository;
import com.example.demo2.exception.ResourceNotFoundException;
import com.example.demo2.model.Guest;

@RestController
@RequestMapping("/hms/")
public class HomeController {

	@Autowired
	private HmsRepository hmsRepository;
	
	@GetMapping("/")
	public String home()
	{
		return("<h1>welcome</h1>");
		
	}
	@GetMapping("/guest")
	public List<Guest> getAllGuest()
	{
		return hmsRepository.findAll();
	}
	@PostMapping("/guest")
	public Guest addguest(@RequestBody Guest guest) {
		return hmsRepository.save(guest);
	}
	@PutMapping("/guest/{id}")
	public ResponseEntity<Guest> updateguest(@PathVariable Long id,@RequestBody Guest guestdetails)
	{
		Guest guest=hmsRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));
		guest.setPhno(guestdetails.getPhno());
		guest.setName(guestdetails.getName());
		guest.setGender(guestdetails.getGender());
	
		guest.setEmail(guestdetails.getEmail());
		guest.setCompany(guestdetails.getCompany());
		guest.setAddress(guestdetails.getAddress());
		
		
	

		Guest updatedGuest = hmsRepository.save(guest);
		return ResponseEntity.ok(updatedGuest);
		
	}
	@DeleteMapping("/guest/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
	Guest guest = hmsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

		hmsRepository.delete(guest);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
     
	
	
}
