package com.raktosh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raktosh.config.MailService;
import com.raktosh.entities.BloodBank;
import com.raktosh.entities.User;
import com.raktosh.models.BloodBankModel;
import com.raktosh.repo.BloodBankRepo;
import com.raktosh.utils.ApiResponse;

@Service
public class BloodBankService {

	@Autowired
	private UserService userService;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private BloodBankRepo bankRepo;
	@Autowired
	private MailService mailService;
	
	public ApiResponse saveBloodBank(BloodBankModel bankModel) {
		try {
			User user = new User(bankModel.getEmail(), passwordEncoder.encode(bankModel.getPassword()), "ROLE_BLOODBANK", false);
			user = userService.saveUser(user);
			
			BloodBank bankObj = new BloodBank(bankModel.getName(), bankModel.getAddress(), bankModel.getPhone(), true, user);
			bankObj = bankRepo.save(bankObj);
			
			mailService.verificationMail(bankModel.getEmail(), bankModel.getName());
			return new ApiResponse(true, "BloodBank Save", bankObj);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Bank Not save", e.getMessage());
		}
	}
	
	
}
