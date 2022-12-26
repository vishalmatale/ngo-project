package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Entity.Admin;
import com.tcs.costant.AppCostant;
import com.tcs.dto.AdminDto;
import com.tcs.dto.LoginDto;
import com.tcs.exceptions.ResourceNotfoundexceptions;
import com.tcs.repopsitery.AdminRepositery;

@Service
public class AdminServiceImpI implements AdminServiceI {

	@Autowired
	private AdminRepositery adminRepositery;

	@Autowired
	private ModelMapper modelMapper;

	Logger logger = LoggerFactory.getLogger(AdminServiceImpI.class);

	@Override
	public AdminDto saveAdmin(AdminDto admindto) {

		Admin admin = this.modelMapper.map(admindto, Admin.class);
		logger.info("inisating AdminiserviceImpI for saveAdmin");
		Admin save = this.adminRepositery.save(admin);
		logger.info("complete AdminiserviceImpI for saveAdmin");
		return this.modelMapper.map(save, AdminDto.class);
	}

	@Override
	public AdminDto updateAdmin(AdminDto admindto, Integer adminId) {

		Admin admin = adminRepositery.findById(adminId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Admin_id + adminId));
		logger.info("inisiating AdminiserviceImpI for updateAdmin");
		admin.setName(admindto.getName());
		admin.setContact(admindto.getContact());
		admin.setGender(admindto.getGender());
		;

		Admin admin2 = adminRepositery.save(admin);

		AdminDto map = modelMapper.map(admin2, AdminDto.class);
		logger.info("inisiating AdminiserviceImpI for updateAdmin");
		return map;
	}

	@Override
	public List<AdminDto> getAllAdmin() {

		List<Admin> all = adminRepositery.findAll();
		logger.info("inisiating AdminiserviceImpI for detallAdmin");
		List<AdminDto> getall = all.stream().map((admin) -> modelMapper.map(admin, AdminDto.class))
				.collect(Collectors.toList());
		logger.info("complete AdminiserviceImpI for getallAdmin");
		return getall;
	}

	@Override
	public AdminDto getById(Integer adminId) {
		logger.info("inisiating AdminiserviceImpI for getByIdAdmin");
		Admin admin = adminRepositery.findById(adminId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Admin_id + adminId));

		AdminDto map = modelMapper.map(admin, AdminDto.class);
		logger.info("complete AdminiserviceImpI for getByIdAdmin");
		return map;
	}

	@Override
	public void deleteById(Integer adminId) {
		logger.info("inisiating AdminiserviceImpI for deleteAdmin");
		Admin admin = adminRepositery.findById(adminId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Admin_id + adminId));

		adminRepositery.delete(admin);
		logger.info("complete AdminiserviceImpI for deleteAdmin");
	}

	@Override
	public AdminDto getAdminlogin(LoginDto logindto) {

		Admin admin = adminRepositery.findByLogin(logindto);

		return modelMapper.map(admin, AdminDto.class);
	}

}
