package com.advertiser.resource;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.advertiser.exception.AdvertiserBusinessException;
import com.advertiser.exception.AdvertiserSystemException;
import com.advertiser.handler.AdvertiserDetailsHandler;
import com.advertiser.mapper.AdvertiserDetailsMapper;
import com.advertiser.response.AdvertiserResponseRO;
import com.advertiser.type.ErrorCodeType.CNInvalid;
import com.advertiser.util.AdvertiserStatus;

import DataObject.AdvertiserDO;
import RequestObject.AdvertiserRO;


@DenyAll
@Produces(MediaType.APPLICATION_JSON)
@Path("/api/advertiser")
public class AdvertiserRS 
{
	@Context
	UriInfo uriInfo;
	
	@Inject
	private AdvertiserDetailsMapper detailsMapper;
	
	private static final String CLASS_NAME =AdvertiserRS.class.getCanonicalName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	/**
	 * This method is to retrieve advertiser details based on a given contactNumber.
	 * @param contactNumber
	 * @return Response
	 */
	@GET
	@Path("{contactNumber}")
	public Response retrieveAdvertiserDetails(@Pattern(regexp="(^$|[0-9]{10})",payload =CNInvalid.class)@PathParam("contactNumber") String contactNumber)
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
		catch (AdvertiserSystemException  systemException) 
		{
			LOGGER.logp(Level.SEVERE, CLASS_NAME, method_name, systemException.getMessage());
			Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return Response.status(Response.Status.OK).entity(responseRO).build();
	}
	
	@POST
	@RolesAllowed({"ALL"})
	public Response createNewAdverstiser(@Valid AdvertiserRO advertiserInputRO)
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
	
	
	
	AdvertiserDetailsMapper getDetailsMapper(){
		return detailsMapper;
	}

}
