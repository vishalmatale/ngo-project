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
import com.tcs.dto.PartnerDto;
import com.tcs.service.PartnerServiceI;

import jakarta.validation.Valid;



@RestController
public class PartnerController {

	@Autowired
	private PartnerServiceI partnerServiceI;

	@PostMapping("/savepartner")
	public ResponseEntity<String> savePartner(@Valid @RequestBody PartnerDto partnerdto) {

		PartnerDto save = partnerServiceI.saveParner(partnerdto);
		return new ResponseEntity<String>(AppCostant.partner_save, HttpStatus.OK);

	}

	@PutMapping("/updatepartner/{partnerId}")
	public ResponseEntity<PartnerDto> updatepartner(@Valid @RequestBody PartnerDto partnerdto, @PathVariable int partnerId) {

		PartnerDto updatePartner = partnerServiceI.updatePartner(partnerdto, partnerId);

		return new ResponseEntity<PartnerDto>(updatePartner, HttpStatus.OK);

	}

	@GetMapping("/getallpartner")
	public ResponseEntity<List<PartnerDto>> getallparter() {

		List<PartnerDto> allPartner = partnerServiceI.getAllPartner();
		return new ResponseEntity<List<PartnerDto>>(allPartner, HttpStatus.OK);

	}

	@GetMapping("/getparter/{partnerId}")
	public ResponseEntity<PartnerDto> getById(@PathVariable int partnerId) {

		PartnerDto byId = partnerServiceI.getById(partnerId);

		return new ResponseEntity<PartnerDto>(byId, HttpStatus.OK);

	}

	@DeleteMapping("/deletepartner/{partnerId}")
	public ResponseEntity<String> deletePartner(@PathVariable int partnerId) {

		partnerServiceI.deleteById(partnerId);

		return new ResponseEntity<String>(AppCostant.partner_delete, HttpStatus.OK);

	}

}
