package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Entity.Donor;
import com.tcs.costant.AppCostant;
import com.tcs.dto.DonorDto;
import com.tcs.exceptions.ResourceNotfoundexceptions;
import com.tcs.repopsitery.DonorRepositery;

@Service
public class DonorServiceImpI implements DonorServiceI {

	@Autowired
	private DonorRepositery donorRepositery;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DonorDto saveDonor(DonorDto donordto) {

		Donor map = modelMapper.map(donordto, Donor.class);

		Donor save = donorRepositery.save(map);

		return modelMapper.map(save, DonorDto.class);
	}

	@Override
	public DonorDto updateDonor(DonorDto donordto, Integer donorId) {

		Donor donor = donorRepositery.findById(donorId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.donor_id + donorId));

		donor.setDonorname(donordto.getDonorname());
		donor.setDonorContact(donordto.getDonorContact());
		donor.setDonorAmount(donordto.getDonorAmount());
		donor.setDonorGender(donordto.getDonorGender());
		donor.setDonorPanno(donordto.getDonorPanno());
		donor.setDonorDob(donordto.getDonorDob());

		return modelMapper.map(donor, DonorDto.class);
	}

	@Override
	public List<DonorDto> getAllDonor() {

		List<Donor> list = donorRepositery.findAll();

		List<DonorDto> collect = list.stream().map((donor) -> modelMapper.map(donor, DonorDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public DonorDto getById(Integer donorId) {

		Donor donor = donorRepositery.findById(donorId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.donor_id + donorId));

		return modelMapper.map(donor, DonorDto.class);
	}

	@Override
	public void deleteById(Integer donorId) {

		Donor donor = donorRepositery.findById(donorId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.donor_id + donorId));

		donorRepositery.delete(donor);

	}

}
