package com.raktosh.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCampModel
{
	private String campTitle;
	private String description;
	private String address;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
  //  private String postor;


}
