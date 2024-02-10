package com.raktosh.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raktosh.entities.BloodBank;
import com.raktosh.entities.Donor;
import com.raktosh.entities.User;
import com.raktosh.models.DonorModel;
import com.raktosh.repo.BloodBankRepo;
import com.raktosh.repo.DonorRepo;
import com.raktosh.utils.ApiResponse;

@Service
public class DonorService 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private DonorRepo donorRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private BloodBankService bankService;
	
	public ApiResponse saveDonor(DonorModel model)
	{
		try 
		{
			User user= new User(model.getEmail(),passwordEncoder.encode(model.getPassword()),"ROLE_DONOR",true);
			user = userService.saveUser(user);
			
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			final User USER = (User)principal;
			
			BloodBank bank = bankService.getBankByUser(USER);
			
			Set<BloodBank> bloodBank = new HashSet<>();
			
			bloodBank.add(bank);
		
			Donor donor = new Donor(model.getName(), model.getPhone(), model.getAddress(), model.getGender(), model.getDob(), model.getBloodGroup(), model.getAadharCard(), model.getType(), user, bloodBank);
			donor = donorRepo.save(donor);
			return new ApiResponse(true, "Donor added", donor);
		}
		catch(Exception ex)
		{
			return new ApiResponse(false, "Donor not saved", ex.getMessage());
		}
	}

	public Donor getDonorByUser(User user) {
		return donorRepo.findByUser(user).get();
	}

}
