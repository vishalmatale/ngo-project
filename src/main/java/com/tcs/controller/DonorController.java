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
import com.tcs.dto.DonorDto;
import com.tcs.service.DonorServiceI;

import jakarta.validation.Valid;


@RestController
public class DonorController {

	@Autowired
	private DonorServiceI donorServiceI;

	@PostMapping("/donorsave")
	public ResponseEntity<String> donorsave(@Valid @RequestBody DonorDto donordto) {

		DonorDto saveDonor = donorServiceI.saveDonor(donordto);

		return new ResponseEntity<String>(AppCostant.donor_save, HttpStatus.OK);

	}

	@PutMapping("updatedonor/{donorId}")
	public ResponseEntity<DonorDto> updatedonor(@Valid @RequestBody DonorDto donordto, @PathVariable int donorId) {

		DonorDto updateDonor = donorServiceI.updateDonor(donordto, donorId);
		return new ResponseEntity<DonorDto>(updateDonor, HttpStatus.OK);

	}

	@GetMapping("/getalldonor")
	public ResponseEntity<List<DonorDto>> getallDonor() {

		List<DonorDto> allDonor = donorServiceI.getAllDonor();
		return new ResponseEntity<List<DonorDto>>(allDonor, HttpStatus.OK);

	}

	@GetMapping("/getdonorId/{donorId}")
	public ResponseEntity<DonorDto> getById(@PathVariable int donorId) {

		DonorDto byId = donorServiceI.getById(donorId);

		return new ResponseEntity<DonorDto>(byId, HttpStatus.OK);

	}

	@DeleteMapping("/deletedonor/{donorId}")
	public ResponseEntity<String> deletedonor(@PathVariable int donorId) {
		donorServiceI.deleteById(donorId);

		return new ResponseEntity<String>(AppCostant.donor_delete, HttpStatus.OK);

	}
	

}
