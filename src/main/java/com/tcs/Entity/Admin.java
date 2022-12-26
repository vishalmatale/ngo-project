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
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ADMIN")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;

	@Column(name = "NAME")
	private String name;

	@Column(name = "CONTACT")
	private String contact;

	@Column(name = "GENDER")
	private String gender;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="loginId")
	private Login login;

	@Embedded
	private Adress adress;
	
	
	

}
