package com.advertiser.response;

public class AdvertiserResponseRO 
{
	private String AdvertiserName;
	private String AdvertiserContactNumber;
	private String AdvertiserCreditScore;

	public String getAdvertiserName() {
		return AdvertiserName;
	}
	public void setAdvertiserName(String advertiserName) {
		AdvertiserName = advertiserName;
	}
	public String getAdvertiserContactNumber() {
		return AdvertiserContactNumber;
	}
	public void setAdvertiserContactNumber(String advertiserContactNumber) {
		AdvertiserContactNumber = advertiserContactNumber;
	}
	public String getAdvertiserCreditScore() {
		return AdvertiserCreditScore;
	}
	public void setAdvertiserCreditScore(String advertiserCreditScore) {
		AdvertiserCreditScore = advertiserCreditScore;
	}
}
