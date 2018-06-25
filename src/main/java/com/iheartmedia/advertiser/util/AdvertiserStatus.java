package com.iheartmedia.advertiser.util;

public class AdvertiserStatus {
	private boolean isCreated;
	private boolean isUpdated;
	private boolean isDeleted;
	
	public boolean isCreated() {
		return isCreated;
	}
	public void setCreated(boolean isCreated) {
		this.isCreated = isCreated;
	}
	public boolean isUpdated() {
		return isUpdated;
	}
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
