package com.tcs.service;

import java.util.List;

import com.tcs.dto.LoginDto;
import com.tcs.dto.StaffDto;

public interface StaffServiceI {

	public StaffDto saveStaff(StaffDto staffdto);

	public StaffDto updateStaff(StaffDto staffdto, Integer staffId);

	public List<StaffDto> getAllStaff();

	public StaffDto getById(Integer staffId);

	public void deleteById(Integer staffId);

	public StaffDto getStaff(LoginDto logindto);
	
	
	
}
