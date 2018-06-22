package com.advertiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.advertiser.exception.AdvertiserBusinessException;
import com.advertiser.exception.AdvertiserSystemException;
import com.advertiser.persistence.DataConnectionprovider;
import com.advertiser.response.AdvertiserResponseRO;
import com.advertiser.util.AdvertiserStatus;

import DataObject.AdvertiserDO;

public class AdvertiserDAOImpl extends  DataConnectionprovider implements IAdvertiserDAO 
{

	@Override
	public  AdvertiserStatus addAdvertiser(AdvertiserDO advertiserDetails) throws AdvertiserSystemException 
	{
		Connection conn = null;
		AdvertiserStatus status = null;
		String sqlQuery = "INSERT INTO Advertiser (Name, ContactNumber,CreditScore) VALUES (?, ?, ?)";
		try {
			conn = this.getConnection();
			if (null != conn) {
				PreparedStatement statement = conn.prepareStatement(sqlQuery);
				statement.setString(1, advertiserDetails.getAdvertiserName());
				statement.setString(2, advertiserDetails.getContactNumber());
				statement.setString(3, advertiserDetails.getCreditScore());
				int rowCount = statement.executeUpdate();
				if (rowCount > 0) {
					status = new AdvertiserStatus();
					status.setCreated(true);
				} else {
					throw new AdvertiserSystemException("Error occured while updating data into DB");
				}
			}
		} catch (SQLException exception) {

			exception.printStackTrace();
			throw new AdvertiserSystemException("Error occured while connecting to DataBase");

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AdvertiserSystemException("Error occured while closing the db connection");
			}
		}
		return status;
	}

	@Override
	public List<AdvertiserDO> getAllAdvertisers() {

		Connection conn = null;
		String sql = "SELECT * FROM Advertiser";
		List<AdvertiserDO> advertiserDoList = new ArrayList<AdvertiserDO>();
		try {
			conn = this.getConnection();
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);		 
			int count = 0;			 
			while (result.next()){
			    String name = result.getString(1);
			    String contactNumber = result.getString(2);
			    String creditScore = result.getString(3);
			    AdvertiserDO advertiserDo=new AdvertiserDO();
			    advertiserDo.setAdvertiserName(name);
			    advertiserDo.setContactNumber(contactNumber);
			    advertiserDo.setCreditScore(creditScore);
			    advertiserDoList.add(advertiserDo);
			} 
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		return advertiserDoList;
		}

	@Override
	public AdvertiserResponseRO getAdvertiser(String number) throws AdvertiserSystemException {
		Connection conn = null;
		AdvertiserResponseRO advertiserResponseRO=new AdvertiserResponseRO();
		String sql = "SELECT * FROM Advertiser WHERE ContactNumber=?";
		try {
			conn = this.getConnection();
			if (null != conn)
			{
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, number);
				ResultSet result = statement.executeQuery(sql);		 			 
				while (result.next()){
				    String name = result.getString(1);
				    String contactNumber = result.getString(2);
				    String creditScore = result.getString(3);
				    advertiserResponseRO.setAdvertiserName(name);
				    advertiserResponseRO.setAdvertiserContactNumber(contactNumber);
				    advertiserResponseRO.setAdvertiserCreditScore(creditScore);
				} 				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			throw new AdvertiserSystemException("Error occured while connecting to DataBase");

		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AdvertiserSystemException("Error occured while closing the db connection");
			}
		}			
		return advertiserResponseRO;
	}

	@Override
	public AdvertiserStatus deleteAdvertiser(String contactNumber) throws AdvertiserSystemException {
		Connection conn = null;
		AdvertiserStatus status = null;
		String sql = "DELETE FROM Advertiser WHERE contactNumber=?";
		try {
			conn = this.getConnection();		
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, contactNumber);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    status = new AdvertiserStatus();
			    status.setDeleted(true);
			} 
		}
		catch (SQLException exception) {
			exception.printStackTrace();
			throw new AdvertiserSystemException("Error occured while connecting to DataBase");

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AdvertiserSystemException("Error occured while closing the db connection");
			}}			
		return status;
	}

	@Override
	public AdvertiserStatus updateAdvertiser(AdvertiserDO advertiserDetails) throws AdvertiserSystemException {
		AdvertiserStatus status = null;
		Connection conn = null;
		String sql = "UPDATE Advertiser SET Name=?, ContactNumber=?, CreditScore=?";		
		try {
			conn = this.getConnection();
			if(null!=conn){
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, advertiserDetails.getAdvertiserName());
				statement.setString(2, advertiserDetails.getContactNumber());
				statement.setString(3, advertiserDetails.getCreditScore());	
			    int rowsUpdated = statement.executeUpdate();
				if (rowsUpdated > 0) {
					status = new AdvertiserStatus();
					status.setUpdated(true);
				} else {
					throw new AdvertiserSystemException("Error occured while updating data into DB");
				}			
			}			 
		}
		catch (SQLException exception) {
			exception.printStackTrace();
			throw new AdvertiserSystemException("Error occured while connecting to DataBase");

		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new AdvertiserSystemException("Error occured while closing the db connection");
			}
		}
		return status;
	}

}
