package com.raktosh.entities;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bloodCollection")
public class BloodCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bloodcollection_id")
    private Integer bloodcollectionId;

    @Column(name = "packetnumber", nullable = false)
    private String packetNumber;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "donor", nullable = false)
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "camp",nullable=true)
    private Camp camp;

    @ManyToOne
    @JoinColumn(name = "bloodbank", nullable = false)
    private BloodBank bloodBank;

    
    @Column(nullable = false)
    private String bloodGroup;

    @Column(name = "status", nullable = false)
    private String status;
}


