package com.tcs.repopsitery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.Entity.Donor;

public interface DonorRepositery extends JpaRepository<Donor, Integer> {

}
