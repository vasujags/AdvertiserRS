package com.advertiser.exception;

import java.util.List;

public class AdvertiserBusinessException extends Exception 
{
	List<String> errorMessages;
	
	public AdvertiserBusinessException(){
		super();
	}
	
	public AdvertiserBusinessException(String message)
	{
		super(message);
	}

}
