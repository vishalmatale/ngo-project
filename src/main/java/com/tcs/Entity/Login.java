package com.tcs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOGINID")
	private Integer loginId;
	
	@Column(name="LOGINNAME")
	private String loginname;
	
	@Column(name="LOGINPASSWARD")
	private String loginpassward;
	
	@Column(name="LOGINTYPE")
	private String logintype;
	
	
	
	

}
