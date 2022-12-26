package com.tcs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.Entity.Partner;
import com.tcs.costant.AppCostant;

import com.tcs.dto.PartnerDto;
import com.tcs.exceptions.ResourceNotfoundexceptions;
import com.tcs.repopsitery.PartnerRepositery;

@Service
public class PartnerServiceImpI implements PartnerServiceI {

	@Autowired
	private PartnerRepositery partnerRepositery;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PartnerDto saveParner(PartnerDto partnerdto) {

		Partner map = modelMapper.map(partnerdto, Partner.class);

		Partner save = partnerRepositery.save(map);

		return modelMapper.map(save, PartnerDto.class);
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerdto, Integer partnerId) {

		Partner partner = partnerRepositery.findById(partnerId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.partner_id + partnerId));

		partner.setPartnercontact(partnerdto.getPartnercontact());
		partner.setPartnerorganizations(partnerdto.getPartnerorganizations());
		partner.setPartnerwebsite(partnerdto.getPartnerwebsite());

		return modelMapper.map(partner, PartnerDto.class);
	}

	@Override
	public List<PartnerDto> getAllPartner() {

		List<Partner> list = partnerRepositery.findAll();

		List<PartnerDto> collect = list.stream().map((partner) -> modelMapper.map(partner, PartnerDto.class))
				.collect(Collectors.toList());

		return collect;
	}

	@Override
	public PartnerDto getById(Integer partnerId) {

		Partner partner = partnerRepositery.findById(partnerId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.partner_id + partnerId));

		return modelMapper.map(partner, PartnerDto.class);
	}

	@Override
	public void deleteById(Integer partnerId) {
		Partner partner = partnerRepositery.findById(partnerId)
				.orElseThrow(() -> new ResourceNotfoundexceptions(AppCostant.partner_id + partnerId));

		partnerRepositery.delete(partner);
	}

}
