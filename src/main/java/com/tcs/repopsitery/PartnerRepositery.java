package com.tcs.repopsitery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.Entity.Partner;

public interface PartnerRepositery extends JpaRepository<Partner, Integer> {

}
