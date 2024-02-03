package com.raktosh.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dispatch_collection")
public class DispatchCollection {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "dispatchCollection_id")
	    private Integer dispatchCollectionId;
	 

	    @ManyToOne
	    @JoinColumn(name = "dispatch", nullable = false)
	    private BloodDispatch dispatch;
	    
	    @ManyToOne
	    @JoinColumn(name = "bloodcollection", nullable = false)
	    private BloodCollection bloodCollection;
	    	
}