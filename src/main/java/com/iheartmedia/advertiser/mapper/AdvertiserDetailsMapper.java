package com.iheartmedia.advertiser.mapper;

import com.iheartmedia.advertiser.dataobject.AdvertiserDO;
import com.iheartmedia.advertiser.requestobject.AdvertiserRO;

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
