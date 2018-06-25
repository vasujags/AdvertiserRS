package com.iheartmedia.advertiser.handler;

import com.iheartmedia.advertiser.exception.AdvertiserBusinessException;
import com.iheartmedia.advertiser.exception.AdvertiserSystemException;
import com.iheartmedia.advertiser.mediator.AdvertiserMediator;
import com.iheartmedia.advertiser.response.AdvertiserResponseRO;
import com.iheartmedia.advertiser.util.AdvertiserStatus;

import com.iheartmedia.advertiser.dataobject.AdvertiserDO;

public class AdvertiserDetailsHandler 
{
  public static AdvertiserStatus createAdvertiserDetails(AdvertiserDO advertiserDetails) throws AdvertiserBusinessException, AdvertiserSystemException
  {	  
	  AdvertiserStatus responseRO = AdvertiserMediator.storeDetailsToDB(advertiserDetails);
	  return responseRO;
  }
  
  
  public static AdvertiserResponseRO retrieveAdvertiserDetails(String contactNumber) throws AdvertiserBusinessException, AdvertiserSystemException
  {	  
	  AdvertiserResponseRO responseRO = AdvertiserMediator.getAdvertiserDetailFromDB(contactNumber);	
	  return responseRO;
  }
  
  public static AdvertiserStatus updateAdvertiserDetails(AdvertiserDO advertiserDetails) throws AdvertiserBusinessException, AdvertiserSystemException
  {	  
	  AdvertiserStatus responseRO = AdvertiserMediator.updateDataIntoDB(advertiserDetails);	
	  return responseRO;
  }
  
  public static AdvertiserStatus deleteAdvertiserDetails(String contactNumber) throws AdvertiserBusinessException, AdvertiserSystemException
  {	  
	  AdvertiserStatus responseRO = AdvertiserMediator.deleteDataFromDB(contactNumber);	
	  return responseRO;
  }
}
