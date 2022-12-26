package com.tcs.controller;

import java.util.List;

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
import com.tcs.dto.StaffDto;
import com.tcs.service.StaffServiceI;

import jakarta.validation.Valid;



@RestController
public class StaffController {

	@Autowired
	private StaffServiceI staffServiceI;

	@PostMapping("/savestaff")
	public ResponseEntity<String> staffdatasave(@Valid @RequestBody StaffDto staffdto) {

		StaffDto saveStaff = staffServiceI.saveStaff(staffdto);

		return new ResponseEntity<String>(AppCostant.staff_save, HttpStatus.CREATED);

	}

	@PutMapping("/staffupdate/{staffId}")
	public ResponseEntity<StaffDto> staffUpdate(@Valid @RequestBody StaffDto staffdto, @PathVariable int staffId) {

		StaffDto updateStaff = staffServiceI.updateStaff(staffdto, staffId);

		return new ResponseEntity<StaffDto>(updateStaff, HttpStatus.OK);

	}

	@GetMapping("/getallstaff")
	public ResponseEntity<List<StaffDto>> getallstaff() {

		List<StaffDto> allStaff = staffServiceI.getAllStaff();

		return new ResponseEntity<>(allStaff, HttpStatus.OK);

	}

	@GetMapping("/getstaff/{staffId}")
	public ResponseEntity<StaffDto> getByStaffId(@PathVariable int staffId) {

		StaffDto byId = staffServiceI.getById(staffId);

		return new ResponseEntity<StaffDto>(byId, HttpStatus.OK);

	}

	@DeleteMapping("/deletestaff/{staffId}")
	public ResponseEntity<String> deleteStaff(@PathVariable int staffId) {

		staffServiceI.deleteById(staffId);

		return new ResponseEntity<String>(AppCostant.staff_delete, HttpStatus.OK);

	}

}
