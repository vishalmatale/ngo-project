package com.tcs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.tcs.costant.AppCostant;
import com.tcs.dto.AdminDto;
import com.tcs.service.AdminServiceI;

import jakarta.validation.Valid;

@RestController
public class AdminController {

	@Autowired
	private AdminServiceI serviceI;

	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@PostMapping("/saveadmin")
	public ResponseEntity<String> saveAdmin(@Valid @RequestBody AdminDto admindto) {

		logger.info("inistaing Admincontroller for saveAdmin");
		AdminDto save = serviceI.saveAdmin(admindto);
		logger.info("complete Admincontroller for saveAdmin");
		System.out.println(save);

		return new ResponseEntity<String>(AppCostant.Admin_save, HttpStatus.CREATED);

	}

	@PutMapping("/updateAdmin/{adminId}")
	public ResponseEntity<AdminDto> updateAdmin(@Valid @RequestBody AdminDto admindto, @PathVariable Integer adminId) {
		logger.info("inistating controller for updateAdmin");
		AdminDto updateAdmin = serviceI.updateAdmin(admindto, adminId);
		logger.info("complete controller for updateAdmin");
		return new ResponseEntity<AdminDto>(updateAdmin, HttpStatus.OK);

	}

	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<AdminDto>> getAllAdmin() {
		logger.info("inisitaing controller for getallAdmin");
		List<AdminDto> allAdmin = serviceI.getAllAdmin();
		logger.info("complete contrroller for getallAdmin");
		return new ResponseEntity<List<AdminDto>>(allAdmin, HttpStatus.OK);

	}

	@GetMapping("/getById/{adminId}")
	public ResponseEntity<AdminDto> getById(@PathVariable Integer adminId) {
		logger.info("inisating controller for getByIdAdmin");
		AdminDto getId = serviceI.getById(adminId);
		logger.info("complete controller for getByIdAdmin");
		return new ResponseEntity<AdminDto>(getId, HttpStatus.OK);

	}

	@DeleteMapping("/deleteById/{adminId}")
	public ResponseEntity<String> deleteById(@PathVariable Integer adminId) {
		logger.info("inisiating controller for deleteAdmin");
		serviceI.deleteById(adminId);
		logger.info("complete controller for deleteAdmin");
		return new ResponseEntity<>(AppCostant.Admin_delete, HttpStatus.OK);

	}

}
