package com.raktosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raktosh.models.DonorModel;
import com.raktosh.services.DonorService;
import com.raktosh.utils.ApiResponse;

@RestController
@RequestMapping("/bloodbank")
public class BloodBankController 
{
	@Autowired
	private DonorService donorService;
	
	@PostMapping("/add_donor")
	public ApiResponse addDonor(@RequestBody DonorModel model)
	{
		ApiResponse response = donorService.saveDonor(model);
		
		return response;
	}

}
