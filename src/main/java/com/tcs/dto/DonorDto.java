package com.tcs.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorDto {

	private int donorId;

	@NotEmpty
	@Size(min=2,max=20,message="min 4 charcter and max 20 charcter")
	private String donorname;

	@NotEmpty
	@Size(max=10,message="max digit is 10")
	private String donorContact;

	@NotEmpty
	@Size(max=10,message="max charcter is 10")
	private String donorPanno;

	 @NotEmpty
	private String donorGender;

	private Date donorDob;

	
	private String donorAmount;

}
