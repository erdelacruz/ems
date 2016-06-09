package com.ems.employee.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.ems.employee.domain.type.GenderType;

@Entity
@Table(name="EMPLOYEE_TABLE")
public class EmployeeEntity implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emplyee_id")
	private Long id;
	private String firstname;
	private String lastname;
	private String middlename;
	
	private Double  generalWeightedAverage;
	
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	@Column(nullable=false)
    @Type(type = "yes_no")
	private Boolean employed;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private AddressEntity address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private ContactEntity contact;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="employee_role", joinColumns=@JoinColumn(name="emplyee_id"), 
	inverseJoinColumns=@JoinColumn(name="role_id"))  
	private Set<RoleEntity> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Double getGeneralWeightedAverage() {
		return generalWeightedAverage;
	}

	public void setGeneralWeightedAverage(Double generalWeightedAverage) {
		this.generalWeightedAverage = generalWeightedAverage;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	

	public Boolean getEmployed() {
		return employed;
	}

	public void setEmployed(Boolean employed) {
		this.employed = employed;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

	public AddressEntity getAddress() {
		return address;
	}

	public void setAddress(AddressEntity address) {
		this.address = address;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}
	
	
	
	
}
