package com.iheartmedia.advertiser.requestobject;

import java.io.Serializable;
import java.math.BigInteger;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdvertiserRO implements Serializable
{
	private static final long serialVersionUID = 5020484873383351406L;
	@NotNull(message = "Name is a Mandatory Field")
	@Size(min = 1, max = 60, message="First name cannot be longer than 60 characters")
	private String advertiserName;
	
	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String contactNumber;
	
	@NotNull(message ="creditscore cannot be null")
	@Size(min = 1, max = 3, message="Creditscore cannot be more than 3 characters")
	private String creditScore;
	
	private BigInteger id;
	
	public String getAdvertiserName() {
		return advertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
}
