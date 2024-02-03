package com.raktosh.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="blood_dispatch")
public class BloodDispatch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blooddispatch_id")
	private Integer BloodDispatchId;
	

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
	
	@Column(name="hospital",nullable=false)
	private String hospital;
	
	@Column(name = "docs")  
	private String docs;
	
	@Column(name="quantity",nullable=false)
	private Integer quantity;
	
	@ManyToOne
    @JoinColumn(name = "bloodbank", nullable = false)
    private BloodBank bloodBank;
	 
}
