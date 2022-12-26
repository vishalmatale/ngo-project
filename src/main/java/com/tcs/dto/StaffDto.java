package com.tcs.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {

	private int staffId;

	@NotEmpty
	@Size(min=2,max=20, message="charcter min 2 and max 20")
	private String staffName;

	@NotEmpty
	@Size(max=10,message="max digit is 10")
	private String satffContact;

	@NotEmpty
	@Size(max=12,message="max addharnumber is 12digits")
	private String staffAddharNumber;

	@NotEmpty
	@Size(min=10,max=30,message="min 10 and max is 30 charcter")
	private String staffDesigenations;

	private String staffGender;

	private Date StaffDob;

}
