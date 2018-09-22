package com.jri.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bank/{accNo}")
public class BankResource {
	
	@Path("/balance/{accNo:\\d+}/{type:.*}")  //d for digit, + for any number of times+, * for anything i.e either number or character
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBalance(@PathParam("accNo") int accountNo, @PathParam("type") String type){
		
		return "AccountNo: " + accountNo + " AccountType: " + type + " Balance: 200.0";
		
	}

}//http://localhost:8080/JaxRsInjection/rest/bank/1/balance/5/saving
