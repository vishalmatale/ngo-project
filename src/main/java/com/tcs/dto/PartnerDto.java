package com.tcs.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PartnerDto {

	private int partnerId;

	@NotBlank
	@Size(min =4,max=30,message="charcter must be min 4 and max=30")
	private String partnerorganizations;
    
	@NotBlank
    private String partnerwebsite;

	
	@NotEmpty
	@Size(max=10,message="max digit is 10")
	private long partnercontact;

}
