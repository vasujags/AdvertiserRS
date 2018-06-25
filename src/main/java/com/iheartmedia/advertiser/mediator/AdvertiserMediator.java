package com.iheartmedia.advertiser.mediator;

import com.iheartmedia.advertiser.dao.AdvertiserDAOImpl;
import com.iheartmedia.advertiser.exception.AdvertiserBusinessException;
import com.iheartmedia.advertiser.exception.AdvertiserSystemException;
import com.iheartmedia.advertiser.response.AdvertiserResponseRO;
import com.iheartmedia.advertiser.util.AdvertiserStatus;

import com.iheartmedia.advertiser.dataobject.AdvertiserDO;

public class AdvertiserMediator 
{
	public static AdvertiserStatus storeDetailsToDB(AdvertiserDO advertiserDetailsDO) throws AdvertiserBusinessException,AdvertiserSystemException
	{
		AdvertiserDAOImpl daoImpl = new AdvertiserDAOImpl();
		AdvertiserStatus responseRO = daoImpl.addAdvertiser(advertiserDetailsDO);
		if(null==responseRO)
		{
			throw new AdvertiserSystemException("Response from the db is null");
		}
		return responseRO;
	}
	
	public static AdvertiserResponseRO getAdvertiserDetailFromDB(String contactNumber) throws AdvertiserBusinessException,AdvertiserSystemException
	{
		AdvertiserDAOImpl daoImpl = new AdvertiserDAOImpl();
		AdvertiserResponseRO advertiserResponseRO = daoImpl.getAdvertiser(contactNumber);
		return advertiserResponseRO;
	}
	
	public static AdvertiserStatus updateDataIntoDB(AdvertiserDO advertiserDetailsDO) throws AdvertiserBusinessException,AdvertiserSystemException
	{
		AdvertiserDAOImpl daoImpl = new AdvertiserDAOImpl();
		AdvertiserStatus responseRO = daoImpl.updateAdvertiser(advertiserDetailsDO);
		if(null==responseRO)
		{
			throw new AdvertiserSystemException("Response from the db is null");
		}
		return responseRO;
	}
	
	public static AdvertiserStatus deleteDataFromDB(String contactNumber) throws AdvertiserBusinessException,AdvertiserSystemException
	{
		AdvertiserDAOImpl daoImpl = new AdvertiserDAOImpl();
		AdvertiserStatus advertiserResponseRO = daoImpl.deleteAdvertiser(contactNumber);
		return advertiserResponseRO;
	}
}
