package com.advertiser.type;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Payload;

import com.advertiser.util.ValidationConstants;

public enum ErrorCodeType 
{
	VALUE_CANNOT_BE_NULL(5013,ValidationConstants.VALUE_CANNOT_BE_NULL_MESSAGE,ValueCannotBeNull.class),
	CONTACTNUMBER_INVALID(5014,ValidationConstants.CONTACT_NUMBER_INVALID,CNInvalid.class);
	
	
	
	
	public static class ValueCannotBeNull implements Payload {}
	public static class CNInvalid implements Payload {}
	
	
	private Integer code;
	private String message;
	private Class<? extends Payload> payLoad;
	
	private static Map<Class<? extends Payload>,ErrorCodeType> codemap = 
			new HashMap<Class<? extends Payload>,ErrorCodeType>();
	
	static
	{
		for(ErrorCodeType type : ErrorCodeType.values())
		{
			codemap.put(type.getPayload(), type);
		}
	}
	
	private ErrorCodeType(Integer code, String message,Class<? extends Payload> payload)
	{
		this.code=code;
		this.message=message;
		this.payLoad = payload;
	}
	
	public Integer getCode()
	{
		return this.code;
		
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public Class<? extends Payload> getPayload()
	{
		return this.payLoad;
	}
	
	public static ErrorCodeType fromPayload(Class<? extends Payload> payload)
	{
		return codemap.get(payload);
	}
}
