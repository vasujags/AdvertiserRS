package com.iheartmedia.advertiser.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.iheartmedia.advertiser.resource.AdvertiserResource;

@ApplicationPath("/v1")
public class AdvertiserApplication extends Application
{		
	 @Override
	 public Set<Class<?>> getClasses() 
	 {
	  Set<Class<?>> classes = new HashSet<Class<?>>();
	  classes.add(AdvertiserResource.class);
	  return classes;
	 }
}
