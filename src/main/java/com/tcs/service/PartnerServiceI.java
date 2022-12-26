package com.tcs.service;

import java.util.List;

import com.tcs.dto.DonorDto;
import com.tcs.dto.PartnerDto;

public interface PartnerServiceI {

	
	public PartnerDto saveParner(PartnerDto partnerdto);

	public PartnerDto updatePartner(PartnerDto partnerdto, Integer partnerId);

	public List<PartnerDto> getAllPartner();

	public PartnerDto getById(Integer partnerId);

	public void deleteById(Integer partnerId);
}
