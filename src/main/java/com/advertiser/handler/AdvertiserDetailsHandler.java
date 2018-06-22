package com.advertiser.handler;

import com.advertiser.exception.AdvertiserBusinessException;
import com.advertiser.exception.AdvertiserSystemException;
import com.advertiser.mediater.AdvertiserMediator;
import com.advertiser.response.AdvertiserResponseRO;
import com.advertiser.util.AdvertiserStatus;

import DataObject.AdvertiserDO;

public class AdvertiserDetailsHandler 
{
  public static AdvertiserStatus createAdvertiserDetails(AdvertiserDO advertiserDetails) throws AdvertiserBusinessException, AdvertiserSystemException
  {
	  final String METHOD_NAME = "createAdvertiserDetails";	  
	  AdvertiserStatus responseRO = AdvertiserMediator.storeDetailsToDB(advertiserDetails);	
	  return responseRO;
  }
  
  
  public static AdvertiserResponseRO retrieveAdvertiserDetails(String contactNumber) throws AdvertiserBusinessException, AdvertiserSystemException
  {
	  final String METHOD_NAME = "retrieveAdvertiserDetails";	  
	  AdvertiserResponseRO responseRO = AdvertiserMediator.getAdvertiserDetailFromDB(contactNumber);	
	  return responseRO;
  }
  
  public static AdvertiserStatus updateAdvertiserDetails(AdvertiserDO advertiserDetails) throws AdvertiserBusinessException, AdvertiserSystemException
  {
	  final String METHOD_NAME = "updateAdvertiserDetails";	  
	  AdvertiserStatus responseRO = AdvertiserMediator.updateDataIntoDB(advertiserDetails);	
	  return responseRO;
  }
  
  public static AdvertiserStatus deleteAdvertiserDetails(String contactNumber) throws AdvertiserBusinessException, AdvertiserSystemException
  {
	  final String METHOD_NAME = "deleteAdvertiserDetails";	  
	  AdvertiserStatus responseRO = AdvertiserMediator.deleteDataFromDB(contactNumber);	
	  return responseRO;
  }
}
