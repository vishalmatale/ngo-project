package com.tcs.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="partnerId")
	private int partnerId;
	
	@Column(name="partnerorganizations")
	private String partnerorganizations;
	
	@Column(name="partnerwebsite")
	private String partnerwebsite;
	
	@Column(name="partnercontact")
	private long partnercontact;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;

	@Embedded
	private Adress adress;


}
