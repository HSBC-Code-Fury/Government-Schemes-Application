package com.hsbc.controller;

import java.sql.Blob;

public class Scheme {
	
	String schemeId;
	String name;
	String summary;
	String description;
	Blob image;
	String ministry;
	String sector;
	String startDate;
	String status;
	String paymentBanks;
	public Scheme(String schemeId, String name, String summary, String description, Blob image, String ministry,
			String sector, String startDate, String status, String paymentBanks) {
		super();
		this.schemeId = schemeId;
		this.name = name;
		this.summary = summary;
		this.description = description;
		this.image = image;
		this.ministry = ministry;
		this.sector = sector;
		this.startDate = startDate;
		this.status = status;
		this.paymentBanks = paymentBanks;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getMinistry() {
		return ministry;
	}
	public void setMinistry(String ministry) {
		this.ministry = ministry;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentBanks() {
		return paymentBanks;
	}
	public void setPaymentBanks(String paymentBanks) {
		this.paymentBanks = paymentBanks;
	}
	@Override
	public String toString() {
		return "Scheme [schemeId=" + schemeId + ", name=" + name + ", summary=" + summary + ", description="
				+ description + ", image=" + image + ", ministry=" + ministry + ", sector=" + sector + ", startDate="
				+ startDate + ", status=" + status + ", paymentBanks=" + paymentBanks + "]";
	}
	
}
