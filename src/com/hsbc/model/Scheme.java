/*
 * @Author Pratham Sharma
 * 
 * Class- Scheme is a model/bean class used for accessing values of Scheme object
 * 
 * 	
 */
package com.hsbc.governmentschemes.model;

import java.util.Date;

public class Scheme {

	private String uniqueId,name,summary,description,ministry,sector,status,paymentBanks;
	private Date startDate;
	

	public Scheme(String uniqueId, String name, String summary, String description, String ministry, String sector,
			 Date startDate,String status, String paymentBanks) {
		super();
		this.uniqueId = uniqueId;
		this.name = name;
		this.summary = summary;
		this.description = description;
		this.ministry = ministry;
		this.sector = sector;
		this.startDate = startDate;
		this.status = status;
		this.paymentBanks = paymentBanks;
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "["+uniqueId+","+name+","+summary+","+description+","+ministry+","+sector+","+startDate+","+status+","+paymentBanks+"]";
	}

	
	
	


	
	
}
