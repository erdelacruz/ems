package com.ems.employee.domain.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


public class EmployeeDTO implements Serializable {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String middlename;
	
	private Double  generalWeightedAverage;
	private String  generalWeightedAverageAsString;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date birthDate;
	
	private String gender;
	
	
	private Boolean employed;
	
	private List<Integer> rolesId;
	private List<RoleDTO> roles;
	
	private List<RoleDTO> selectedRoles;
	
	
	//CONTACT
	private String contactType;
	private String contactNumber;
	
	//ADDRESS
	private String street;
	private String barangay;
	private String city;
	private String houseNumber;
	private String subdivision;
	private String zipCode;
	

	

	public List<RoleDTO> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<RoleDTO> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	public String getGeneralWeightedAverageAsString() {
		return generalWeightedAverageAsString;
	}

	public void setGeneralWeightedAverageAsString(String generalWeightedAverageAsString) {
		this.generalWeightedAverageAsString = generalWeightedAverageAsString;
	}

	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

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
		if(generalWeightedAverageAsString!=null){
			return Double.parseDouble(generalWeightedAverageAsString);
		}
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

	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getEmployed() {
		return employed;
	}

	public void setEmployed(Boolean employed) {
		this.employed = employed;
	}

	

	public List<Integer> getRolesId() {
		return rolesId;
	}

	public void setRolesId(List<Integer> rolesId) {
		this.rolesId = rolesId;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getSubdivision() {
		return subdivision;
	}

	public void setSubdivision(String subdivision) {
		this.subdivision = subdivision;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
	public String getFullname(){
		return firstname+" "+middlename.charAt(0)+". "+lastname;
	}
	
	public String getBirthDateAsString(){
		SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy");
		return format.format(this.birthDate);
	}
	
	public String isEmployee(){
		return (this.employed==true?"Yes":"No");
	}
	
}
