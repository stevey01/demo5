package com.example.guest.ServiceImpl;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.guest.Service.GuestService;
import com.example.guest.exception.ResourceNotFoundException;
import com.example.guest.model.Guest;
import com.example.guest.repository.GuestRepository;



@Service
public class GuestServiceImpl implements GuestService  {
@Autowired
	GuestRepository guestrepository;

	@Override
	public List<Guest> getallguest() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				return guestrepository.findAll();
	}
	

	@Override
	public Guest createguest(Guest guests) {
		// TODO Auto-generated method stub
		//Guest  guest= new Guest();
        //BeanUtils.copyProperties(guestdto, guest);
        Guest guest= guestrepository.save(guests);
        return  guest;
	}

	@Override
	public Guest updateguest(Long id, Guest guestdetails) {
		// TODO Auto-generated method stub
		
		Guest guest= guestrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" id not exist :" + id));
		
		guest.setPhno(guestdetails.getPhno());
		guest.setName(guestdetails.getName());
		guest.setGender(guestdetails.getGender());
	
		guest.setEmail(guestdetails.getEmail());
		guest.setCompany(guestdetails.getCompany());
		guest.setAddress(guestdetails.getAddress());
		
		
		
		Guest guests= guestrepository.save(guest);
		return guests;
		
	}

	@Override
	public void deleteguest(Long id) {
		// TODO Auto-generated method stub
		Guest guest = guestrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Guest not exist with id :" + id));

		guestrepository.delete(guest);
	}
	@Override
	public Guest getguestbyid(Long id) {
		// TODO Auto-generated method stub
		 return guestrepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Guest not found with id: " + id));
		
	}

}
