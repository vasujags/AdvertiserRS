package com.iheartmedia.advertiser.resource;

import com.iheartmedia.advertiser.dataobject.AdvertiserDO;
import com.iheartmedia.advertiser.exception.AdvertiserBusinessException;
import com.iheartmedia.advertiser.exception.AdvertiserSystemException;
import com.iheartmedia.advertiser.handler.AdvertiserDetailsHandler;
import com.iheartmedia.advertiser.mapper.AdvertiserDetailsMapper;
import com.iheartmedia.advertiser.requestobject.AdvertiserRO;
import com.iheartmedia.advertiser.response.AdvertiserResponseRO;
import com.iheartmedia.advertiser.type.ErrorCodeType;
import com.iheartmedia.advertiser.util.AdvertiserStatus;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Level;
import java.util.logging.Logger;


@DenyAll
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/advertiser")
public class AdvertiserResource
{
	@Context
	UriInfo uriInfo;
	
	private static final String CLASS_NAME =AdvertiserResource.class.getCanonicalName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	/**
	 * This method is to retrieve advertiser details based on a given contactNumber.
	 * @param contactNumber
	 * @return Response
	 */
	@GET
	@Path("{contactNumber}")
	public Response retrieveAdvertiserDetails(@Pattern(regexp="(^$|[0-9]{10})",payload =ErrorCodeType.ContactNumberInvalid.class)@PathParam("contactNumber") String contactNumber)
	{
		 final String method_name ="retrieveAdvertiser";
		AdvertiserResponseRO responseRO = null;
		try {
			 responseRO = AdvertiserDetailsHandler.retrieveAdvertiserDetails(contactNumber);
		} 
		catch (AdvertiserBusinessException  businessException) 
		{
			LOGGER.logp(Level.SEVERE, CLASS_NAME, method_name, businessException.getMessage());
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		catch (AdvertiserSystemException systemException)
		{
			LOGGER.logp(Level.SEVERE, CLASS_NAME, method_name, systemException.getMessage());
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return Response.status(Response.Status.OK).entity(responseRO).build();
	}
	
	@POST
	@RolesAllowed({"ALL"})
	public Response createNewAdvertiser(@Valid AdvertiserRO advertiserInputRO)
	{
		AdvertiserStatus responseRO = null;
		AdvertiserDO advertiserDO = AdvertiserDetailsMapper.mapAdvertiserDetailsFromROTODO(advertiserInputRO);
		try 
		{			
			 responseRO = AdvertiserDetailsHandler.createAdvertiserDetails(advertiserDO);
			
		} catch (AdvertiserBusinessException  businessException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, "createNewAdverstiser", businessException.getMessage());
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		catch (AdvertiserSystemException  systemException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, "createNewAdverstiser", systemException.getMessage());
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
			return Response.ok(responseRO.isCreated()).build();		
	}
	
	@PUT
	@RolesAllowed({"ALL"})
	public Response updateAdvertiserDetails(@Valid AdvertiserRO advertiserInputRO)
	{
		AdvertiserStatus responseRO = null;
		AdvertiserDO advertiserDO = AdvertiserDetailsMapper.mapAdvertiserDetailsFromROTODO(advertiserInputRO);
		try 
		{			
			 responseRO = AdvertiserDetailsHandler.updateAdvertiserDetails(advertiserDO);
			
		} catch (AdvertiserBusinessException  businessException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, "updateAdverstiser", businessException.getMessage());
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		catch (AdvertiserSystemException  systemException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, "updateAdverstiser", systemException.getMessage());
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
			return Response.ok(responseRO.isUpdated()).build();
	}
	
	@DELETE
	@RolesAllowed({"ALL"})
	public Response deleteAdvertiserDetails(@Pattern(regexp="(^$|[0-9]{10})")@PathParam("contactNumber") String contactNumber)
	{
		final String method_name ="deleteAdvertiser";
		AdvertiserStatus responseRO = null;
		try {
			 responseRO = AdvertiserDetailsHandler.deleteAdvertiserDetails(contactNumber);
		} 
		catch (AdvertiserBusinessException  businessException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, method_name, businessException.getMessage());
			Response.status(Response.Status.BAD_REQUEST).build();
		}
		catch (AdvertiserSystemException  systemException) 
		{
			Logger.getLogger(CLASS_NAME).logp(Level.SEVERE, CLASS_NAME, method_name, systemException.getMessage());
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}		
		return Response.ok(responseRO.isDeleted()).build();
	}

}
