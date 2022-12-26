package com.tcs.service;

import com.tcs.dto.LoginDto;

public interface LoginService {

	
	public LoginDto savelogin(LoginDto logindto);
	
	public LoginDto getlogin(String loginname,String loginpassward );
	
}
