package com.raktosh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.raktosh.entities.BloodBank;
import com.raktosh.entities.Camp;
import com.raktosh.entities.User;
import com.raktosh.models.AddCampModel;
import com.raktosh.repo.CampRepo;
import com.raktosh.utils.ApiResponse;

@Service
public class CampService
{

	@Autowired
	BloodBankService bbservice;
	
	@Autowired
	CampRepo campRepo;
	
	public ApiResponse addCamp(AddCampModel model) 
	{
		try 
		{
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			final User USER = (User)principal;
			
			BloodBank bloodbank = bbservice.getBankByUser(USER);
			
			Camp camp = new Camp(model.getCampTitle(), model.getDescription(), model.getAddress(), model.getStartDate(), model.getEndDate(), null, bloodbank);
			campRepo.save(camp);
			return new ApiResponse(true, "Camp added", camp);
		}
		
		catch(Exception ex)
		{
			return new ApiResponse(false, ex.getMessage());
		}
		
	}
	

}
