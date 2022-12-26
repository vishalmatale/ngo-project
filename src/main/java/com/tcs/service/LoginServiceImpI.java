package com.tcs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Entity.Login;
import com.tcs.dto.LoginDto;
import com.tcs.repopsitery.LoginRepositery;

@Service
public class LoginServiceImpI implements LoginService {

	@Autowired
	private LoginRepositery loginRepositery;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LoginDto savelogin(LoginDto logindto) {

		Login map = modelMapper.map(logindto, Login.class);

		Login save = loginRepositery.save(map);

		LoginDto map2 = modelMapper.map(save, LoginDto.class);

		return map2;
	}

	@Override
	public LoginDto getlogin(String loginname, String loginpassward) {

		Login nameAndLoginPassward = loginRepositery.findByLoginnameAndLoginpassward(loginname, loginpassward);

		return modelMapper.map(nameAndLoginPassward, LoginDto.class);
	}

}
