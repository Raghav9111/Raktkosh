package com.raktosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raktosh.entities.BloodBank;
import com.raktosh.models.BloodBankModel;
import com.raktosh.services.BloodBankService;
import com.raktosh.utils.ApiResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BloodBankService bankService;
	
	@PostMapping("/bank_reg")
	public ApiResponse bloodBankReg(@RequestBody BloodBankModel bankModel) {
			ApiResponse response = bankService.saveBloodBank(bankModel);
			return response;
		
	}
	
}
