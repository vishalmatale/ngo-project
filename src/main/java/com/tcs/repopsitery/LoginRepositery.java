package com.tcs.repopsitery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.Entity.Login;

public interface LoginRepositery extends JpaRepository<Login, Integer>{

	
	public Login findByLoginnameAndLoginpassward(String loginname,String loginpassward);
	
}
