package com.apc.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.apc.bean.Cheque;

@Path("/bank")
public class BankResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/status/{chequeNo}")
	public String getChequeClearenceStatus(@PathParam("chequeNo") Cheque cheque) {

		return "ChequeNo: " + cheque.getChequeNo() + " IFSC Code: "
				+ cheque.getIfscCode() + " has been cleared";
		
	}//http://localhost:8082/AutomaticParamConversionWeb/rest/bank/status/SBI1214-4521
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("cheque-status")
	public String getCheckClearanceDetails(
			@QueryParam("ifscCode") List<Cheque> cheques) {
		
		StringBuffer buffer = new StringBuffer();

		for (Cheque cheque : cheques) {
			buffer.append(
					"IFSC Code : " + cheque.getIfscCode() + " Cheque No : "
							+ cheque.getChequeNo()
							+ " status - under-clearance").append("\n");
		}
		
		return buffer.toString();
		
	}//localhost:8082/AutomaticParamConversionWeb/rest/bank/cheque-status?ifscCode=SBI1214-5421

}
