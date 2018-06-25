package com.iheartmedia.advertiser.dao;

import java.util.List;

import com.iheartmedia.advertiser.exception.AdvertiserBusinessException;
import com.iheartmedia.advertiser.exception.AdvertiserSystemException;
import com.iheartmedia.advertiser.response.AdvertiserResponseRO;
import com.iheartmedia.advertiser.util.AdvertiserStatus;

import com.iheartmedia.advertiser.dataobject.AdvertiserDO;

public interface IAdvertiserDAO 
{
	public AdvertiserStatus addAdvertiser(AdvertiserDO adveriserDO) throws AdvertiserBusinessException, AdvertiserSystemException;
	public List<AdvertiserDO> getAllAdvertisers();
	public AdvertiserResponseRO getAdvertiser(String number) throws AdvertiserSystemException,AdvertiserSystemException;
	public AdvertiserStatus deleteAdvertiser(String contactNumber) throws AdvertiserSystemException;
    public AdvertiserStatus updateAdvertiser(AdvertiserDO advertiserDetails) throws AdvertiserSystemException;
	
	

}
