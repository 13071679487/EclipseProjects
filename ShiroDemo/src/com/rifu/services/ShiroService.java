package com.rifu.services;

import org.apache.shiro.authz.annotation.RequiresRoles;

public class ShiroService {
	
	@RequiresRoles({"admin"})
	public void testMethod(){
		System.out.println("ShiroService testMethod...");
	}
}
