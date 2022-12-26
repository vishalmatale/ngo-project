package com.tcs.Entity;

import java.util.Date;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STAFFID")
	private int staffId;

	@Column(name = "STAFFNAME")
	private String staffName;

	@Column(name = "STAFFCONTACT")
	private String satffContact;

	@Column(name = "STAFFADDHARNUMBER")
	private String staffAddharNumber;

	@Column(name = "STAFFDESIGENATIONS")
	private String staffDesigenations;

	@Column(name = "STAFFGENDER")
	private String staffGender;

	@Column(name = "STAFFDOB")
	private Date StaffDob;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loginId")
	private Login login;

	@Embedded
	private Adress adress;

}
