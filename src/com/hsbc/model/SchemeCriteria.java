package com.hsbc.governmentschemes.model;

public class SchemeCriteria {

	private String profession,incomeGroup,gender,documents,uniqueId;
	private int minAge,maxAge;
	public SchemeCriteria() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SchemeCriteria(String uniqueId,String profession, String incomeGroup, String gender, String documents, int minAge,
			int maxAge) {
		super();
		this.uniqueId = uniqueId;
		this.profession = profession;
		this.incomeGroup = incomeGroup;
		this.gender = gender;
		this.documents = documents;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIncomeGroup() {
		return incomeGroup;
	}
	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDocuments() {
		return documents;
	}
	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	
}
