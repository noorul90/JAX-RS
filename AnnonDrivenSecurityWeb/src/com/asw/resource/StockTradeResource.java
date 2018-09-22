package com.asw.resource;

import java.util.UUID;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.asw.dto.BuyOrder;
import com.asw.dto.Invoice;

@Path("/trading")
public class StockTradeResource {
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/buy")
	@RolesAllowed("trader")
	public Invoice buyStock(BuyOrder order) {
		String status = null;
		Invoice invoice = null;

		if (order.getCustomerID() == 1) {
			status = "active";
		} else {
			status = "suspended";
		}
		if (status.equals("suspended") == true) {
			throw new NotAuthorizedException(Response.status(Status.FORBIDDEN
					.getStatusCode()));
		}

		invoice = new Invoice();
		invoice.setInvoiceNo(UUID.randomUUID().toString());
		invoice.setStatus("partial");

		return invoice;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/status/{customerId}")
	@RolesAllowed({"admin","trader"})
	public String getAccountStatus(@PathParam("customerId") int customerID) {

		return "active";
	}

}
