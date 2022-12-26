package com.tcs.service;

import java.util.List;


import com.tcs.dto.DonorDto;
import com.tcs.dto.PartnerDto;

public interface DonorServiceI {

	public DonorDto saveDonor(DonorDto donordto);

	public DonorDto updateDonor(DonorDto donordto, Integer donorId);

	public List<DonorDto> getAllDonor();

	public DonorDto getById(Integer donorId);

	public void deleteById(Integer donorId);
	

}


