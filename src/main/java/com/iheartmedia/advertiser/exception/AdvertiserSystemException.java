package com.iheartmedia.advertiser.exception;

import java.util.List;

public class AdvertiserSystemException extends Exception
{
	String message;
	
	AdvertiserSystemException(){
		super();
	}
	
	public AdvertiserSystemException(String message){
		super(message);
		this.message=message;
	}
}
