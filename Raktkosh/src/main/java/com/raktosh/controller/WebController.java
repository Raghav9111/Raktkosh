package com.raktosh.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raktosh.config.JwtTokenUtil;
import com.raktosh.models.LoginResponse;
import com.raktosh.entities.User;
import com.raktosh.models.BloodBankModel;
import com.raktosh.models.LoginModel;
import com.raktosh.services.UserService;
import com.raktosh.utils.ApiResponse;


@RestController
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
	public ApiResponse login(@RequestBody LoginModel loginModel) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(),loginModel.getPassword()));

			User user =  (User) userService.loadUserByUsername(loginModel.getEmail());
			System.out.println(user);
			final String token = jwtTokenUtil.generateToken(user);
			LoginResponse lp = new LoginResponse(user.getEmail(), token, user.getRole());
			
			return new ApiResponse(true, "Login Success !", lp);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Login Unsuccessful", e.getMessage());
		}
	}
	@GetMapping("/verify/{email}")
	public ApiResponse verifyAccount(@PathVariable(name="email") String email) {
		Optional<User> op = userService.findByEmail(email);
		if(op.isPresent()) {
			User user = op.get();
			user.setActiveStatus(true);
			user = userService.update(user);
			return new ApiResponse(true, "Account Verified");
		}
		else {
			return new ApiResponse(false, "Account not Verified");
		}
	}
	
}

