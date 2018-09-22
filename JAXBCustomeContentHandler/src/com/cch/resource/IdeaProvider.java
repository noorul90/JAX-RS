package com.cch.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cch.dto.Reciept;
import com.cch.dto.Subscriber;

@Path("/idea")
public class IdeaProvider {
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Path("/recharge")
	public Reciept recharge(Subscriber subscriber){
		Reciept reciept = null;
		reciept = new Reciept();
		
		reciept.setRecieptNo(UUID.randomUUID().toString());
		reciept.setMobile(subscriber.getMobile());
		reciept.setBalance(subscriber.getAmount());
		reciept.setStatus("SUCCESS");
		
		return reciept;
		
	}

}
