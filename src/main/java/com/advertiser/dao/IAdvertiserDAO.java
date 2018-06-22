package com.advertiser.dao;

import java.util.List;

import com.advertiser.exception.AdvertiserBusinessException;
import com.advertiser.exception.AdvertiserSystemException;
import com.advertiser.response.AdvertiserResponseRO;
import com.advertiser.util.AdvertiserStatus;

import DataObject.AdvertiserDO;

public interface IAdvertiserDAO 
{
	public AdvertiserStatus addAdvertiser(AdvertiserDO adveriserDO) throws AdvertiserBusinessException, AdvertiserSystemException;
	public List<AdvertiserDO> getAllAdvertisers();
	public AdvertiserResponseRO getAdvertiser(String number) throws AdvertiserSystemException,AdvertiserSystemException;
	public AdvertiserStatus deleteAdvertiser(String contactNumber) throws AdvertiserSystemException;
    public AdvertiserStatus updateAdvertiser(AdvertiserDO advertiserDetails) throws AdvertiserSystemException;
	
	

}
