package com.raktosh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raktosh.entities.User;
import com.raktosh.models.ChangePasswordModel;
import com.raktosh.services.UserService;
import com.raktosh.utils.ApiResponse;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/change_password")
	public ApiResponse change(@RequestBody ChangePasswordModel model) {
		try {
			System.out.println(model);
			User user = null;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if(principal!=null) {
				user = (User)principal;
				if(passwordEncoder.matches(model.getOldPassword(), user.getPassword())) {
					if(model.getConfirmPassword().equals(model.getNewPassword())) {
						user.setPassword(passwordEncoder.encode(model.getNewPassword()));
						user = userService.update(user);
					}
					else {
						return new ApiResponse(false, "New Password & Confirm Password Not Matched");
					}
				}
				else {
					return new ApiResponse(false, "Old Password Not Matched");
				}
			}
			return new ApiResponse(true, "password Changed",user);
		}
		catch(Exception e) {
			return new ApiResponse(false, "Password Update Error", e.getMessage());
		}
	}
}
