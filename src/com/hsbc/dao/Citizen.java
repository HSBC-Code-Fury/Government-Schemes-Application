package com.hsbc.dao;

import java.util.Date;

public class Citizen {
	
	String uniqueId;
	String name;
	Date dob;
	String gender;
	String email;
	String phone;
	String address;
	String incomeGroup;
	String profession;
	String aadhar;
	String pan;
	
	public Citizen(String uniqueId, String name, Date dob, String gender, String email, String phone, String address,
			String incomeGroup, String profession, String aadhar, String pan) {
		super();
		this.uniqueId = uniqueId;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.incomeGroup = incomeGroup;
		this.profession = profession;
		this.aadhar = aadhar;
		this.pan = pan;
	}
	
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIncomeGroup() {
		return incomeGroup;
	}
	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	
	@Override
	public String toString() {
		return "Citizen [uniqueId=" + uniqueId + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", address=" + address + ", incomeGroup=" + incomeGroup + ", profession="
				+ profession + ", aadhar=" + aadhar + ", pan=" + pan + "]";
	}
}
