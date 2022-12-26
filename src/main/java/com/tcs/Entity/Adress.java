package com.tcs.Entity;



import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adress {
	
	
	private String Area;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pincode;
	

}
