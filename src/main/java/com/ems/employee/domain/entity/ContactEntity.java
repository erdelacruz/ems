package com.ems.employee.domain.entity;

import java.io.Serializable;

import javax.persistence.*;


import com.ems.employee.domain.type.MobileType;
@Entity
@Table(name="CONTACT_TABLE")
public class ContactEntity implements Serializable {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private MobileType type;
	private String contactNumber;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MobileType getType() {
		return type;
	}
	public void setType(MobileType type) {
		this.type = type;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	
	
}
