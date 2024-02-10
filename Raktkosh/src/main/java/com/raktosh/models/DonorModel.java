package com.raktosh.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorModel
{
	private String name;
	private String phone;
	private String address;
	private String gender;
	private String email;
	private String password;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	private String bloodGroup;
	private String type;
	private String aadharCard;
	
	
}
