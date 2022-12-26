package com.tcs.Entity;

import java.sql.Date;

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
public class Donor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="DONORID")
	private int donorId;

	@Column(name ="DONORNAME")
	private String donorname;

	@Column(name ="DONORCONTACT")
	private String donorContact;

	@Column(name ="DONORPANNO")
	private String donorPanno;

	@Column(name ="DONORGENDER")
	private String donorGender;

	@Column(name ="DONORDOB")
	private Date donorDob;

	@Column(name ="DONORAMOUNT")
	private String donorAmount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;

	@Embedded
	private Adress adress;


}
