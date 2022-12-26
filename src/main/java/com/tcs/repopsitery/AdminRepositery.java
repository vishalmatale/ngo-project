package com.tcs.repopsitery;

import org.springframework.data.jpa.repository.JpaRepository;


import com.tcs.Entity.Admin;

import com.tcs.dto.LoginDto;

public interface AdminRepositery extends JpaRepository<Admin, Integer>{

	
	
	public Admin findByLogin(LoginDto logdto);
	
}
