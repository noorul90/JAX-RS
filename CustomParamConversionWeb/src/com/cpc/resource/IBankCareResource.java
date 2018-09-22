package com.cpc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cpc.dto.Cheque;

@Path("/ibank-care")
public class IBankCareResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cheque/{chequeNo}/status")
	public String getChequeStatus(@PathParam("chequeNo") Cheque cheque) {

		return "IFSC Code: " + cheque.getIfscCode() + " ChequeNo: "
				+ cheque.getChequeNo() + " Status: cleared";

	}

}//http://localhost:8082/CustomParamConversionWeb/rest/ibank-care/cheque/f121fg-122/status
