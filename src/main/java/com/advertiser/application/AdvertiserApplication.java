package com.advertiser.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.advertiser.resource.AdvertiserRS;

@ApplicationPath("/v1")
public class AdvertiserApplication extends Application
{		
	 @Override
	 public Set<Class<?>> getClasses() 
	 {
	  Set<Class<?>> classes = new HashSet<Class<?>>();
	  classes.add(AdvertiserRS.class);
	  return classes;
	 }
}
