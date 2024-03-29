package com.raktosh.entities;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Donor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donor_id")
    private Integer donorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String gender;

    
    
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Column(name = "bloodgroup", nullable = false)
    private String bloodGroup;

    @Column(nullable = false,unique = true)
    private String aadharCard;

    
    @Column(name = "lastdonatedate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastDonateDate;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private User user;
    
    @ManyToMany
    @JoinTable(name="donorBank",
    joinColumns = {
    		@JoinColumn(name="donorId",referencedColumnName  ="donor_id")},
    inverseJoinColumns = {
    		@JoinColumn(name="bankId",referencedColumnName  ="bank_id")
    })
    private Set<BloodBank> banks = new HashSet<BloodBank>();

	public Donor(String name, String phone, String address, String gender, LocalDate dob, String bloodGroup,
			String aadharCard, String type, User user, Set<BloodBank> banks) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.bloodGroup = bloodGroup;
		this.aadharCard = aadharCard;
		this.type = type;
		this.user = user;
		this.banks = banks;
	}
    
    
}
