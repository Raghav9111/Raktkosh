package com.raktosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raktosh.entities.Donor;
import com.raktosh.entities.User;
import com.raktosh.services.DonorService;
import com.raktosh.utils.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/donor")
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@GetMapping("/getDonor")
	public ApiResponse getDonor() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			final User USER = (User)principal;
			
			Donor donor = donorService.getDonorByUser(USER);
			
			return new ApiResponse(true, "Donor Details", donor);
			
		}
		catch(Exception e) {
			return new ApiResponse(false, "Donor Details not found", e.getMessage());
		}
	}
	
}
