package com.tcs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

	private Integer loginId;

	private String loginname;

	private String loginpassward;

	private String logintype;

}
