package com.tcs.repopsitery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.Entity.Staff;
import com.tcs.dto.LoginDto;

public interface StaffRepositery extends JpaRepository<Staff, Integer> {

	
	
	public Staff findByLogin(LoginDto logindto);
	
}
