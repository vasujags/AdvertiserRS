package com.advertiser.mapper;

import DataObject.AdvertiserDO;
import RequestObject.AdvertiserRO;

public class AdvertiserDetailsMapper 
{
	public static AdvertiserDO mapAdvertiserDetailsFromROTODO(AdvertiserRO advertiserRO)
	{
		AdvertiserDO advertiserDO = new AdvertiserDO();
		advertiserDO.setAdvertiserName(advertiserRO.getAdvertiserName());
		advertiserDO.setContactNumber(advertiserRO.getContactNumber());
		advertiserDO.setCreditScore(advertiserRO.getCreditScore());	
		return advertiserDO;
	}
	

}
