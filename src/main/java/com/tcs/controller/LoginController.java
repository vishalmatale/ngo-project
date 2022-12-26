package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.AdminDto;
import com.tcs.dto.LoginDto;
import com.tcs.dto.StaffDto;
import com.tcs.service.AdminServiceI;
import com.tcs.service.DonorServiceI;
import com.tcs.service.LoginService;
import com.tcs.service.PartnerServiceI;
import com.tcs.service.StaffServiceI;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private AdminServiceI adminServiceI;

	@Autowired
	private DonorServiceI donorServiceI;

	@Autowired
	private PartnerServiceI partnerServiceI;

	@Autowired
	private StaffServiceI staffServiceI;

	@PostMapping("/savelogin")
	public ResponseEntity<LoginDto> savelogin(@RequestBody LoginDto logindto) {

		LoginDto loginDto2 = loginService.savelogin(logindto);
		
		return new ResponseEntity<LoginDto>(loginDto2,HttpStatus.OK);

	}

	@GetMapping("/getlogin/{loginname}/{loginpassward}")
	public Object getloginnamepassward(@PathVariable String loginname, @PathVariable String loginpassward) {

		LoginDto logindto = loginService.getlogin(loginname, loginpassward);

		if (logindto.getLogintype().equalsIgnoreCase("Admin")) {

			AdminDto admindto = adminServiceI.getAdminlogin(logindto);

			return admindto;

		} else if (logindto.getLogintype().equalsIgnoreCase("Staff")) {

			StaffDto staffdto = staffServiceI.getStaff(logindto);

			return staffdto;
		}
		return logindto;
	}
}