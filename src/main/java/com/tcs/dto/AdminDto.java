package com.tcs.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private Integer adminId;

	@NotEmpty
	@Size(min = 4, max = 20, message = "name must be min 4 character and max 20 character")
	private String name;

	@NotEmpty
	@Size(max=10,message="max charcter 10")
	private String contact;

	@NotEmpty
	private String gender;

}
