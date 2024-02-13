package com.raktosh.entities;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Camp")
public class Camp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camp_id")
    private Integer campId;

    @Column(name = "camp_title", nullable = false)
    private String campTitle;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(name = "postor")  
    private String postor;

    @ManyToOne
    @JoinColumn(name = "bloodbank", nullable = false)
    private BloodBank bloodBank;

	public Camp(String campTitle, String description, String address, LocalDate startDate, LocalDate endDate,
			String postor, BloodBank bloodBank) {
		super();
		this.campTitle = campTitle;
		this.description = description;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.postor = postor;
		this.bloodBank = bloodBank;
	}

   
}
