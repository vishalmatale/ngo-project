package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Entity.Staff;
import com.tcs.costant.AppCostant;
import com.tcs.dto.LoginDto;
import com.tcs.dto.StaffDto;
import com.tcs.exceptions.ResourceNotfoundexceptions;
import com.tcs.repopsitery.StaffRepositery;

@Service
public class StaffServiceImpI implements StaffServiceI {

	@Autowired
	private StaffRepositery staffRepositery;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffDto saveStaff(StaffDto staffdto) {

		Staff map = modelMapper.map(staffdto, Staff.class);

		Staff save = staffRepositery.save(map);

		return modelMapper.map(save, StaffDto.class);
	}

	@Override
	public StaffDto updateStaff(StaffDto staffdto, Integer staffId) {

		Staff staff = staffRepositery.findById(staffId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Staff_id + staffId));

		staff.setStaffName(staffdto.getStaffName());
		staff.setSatffContact(staffdto.getSatffContact());
		staff.setStaffAddharNumber(staffdto.getStaffAddharNumber());
		staff.setStaffGender(staffdto.getStaffGender());
		staff.setStaffDesigenations(staffdto.getStaffDesigenations());
		staff.setStaffDob(staffdto.getStaffDob());

		return modelMapper.map(staff, StaffDto.class);
	}

	@Override
	public List<StaffDto> getAllStaff() {
		List<Staff> all = staffRepositery.findAll();

		List<StaffDto> list = all.stream().map((staff) -> modelMapper.map(staff, StaffDto.class))
				.collect(Collectors.toList());

		return list;
	}

	@Override
	public StaffDto getById(Integer staffId) {

		Staff staff = staffRepositery.findById(staffId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Staff_id + staffId));

		return modelMapper.map(staff, StaffDto.class);
	}

	@Override
	public void deleteById(Integer staffId) {

		Staff staff = staffRepositery.findById(staffId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.Staff_id + staffId));

		staffRepositery.delete(staff);

	}

	@Override
	public StaffDto getStaff(LoginDto logindto) {
		
		Staff staff = staffRepositery.findByLogin(logindto);
		
		return modelMapper.map(staff, StaffDto.class);
	}

}
