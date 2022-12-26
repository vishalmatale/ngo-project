package com.tcs.service;

import java.util.List;



import com.tcs.dto.AdminDto;
import com.tcs.dto.LoginDto;

public interface AdminServiceI {

	
	public AdminDto saveAdmin(AdminDto admindto);
	
	
	public AdminDto updateAdmin(AdminDto admindto,Integer adminId);
	
	
	public List<AdminDto>getAllAdmin();
	
	
	public AdminDto getById(Integer adminId);
	
	
	public void deleteById(Integer adminId);
	
	
	public AdminDto getAdminlogin(LoginDto logindto );
	
}
