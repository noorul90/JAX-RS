package com.cpc.converter;

import javax.ws.rs.ext.ParamConverter;

import com.cpc.dto.Cheque;

//call by jax-rs runtime
public class ChequeParamConverter implements ParamConverter<Cheque> {

	//String type converted into Cheque type when string value send as part of request uri
	@Override
	public Cheque fromString(String param) {
		String[] tokens = null;
		tokens = param.split("-");
		String ifsc = tokens[0];
		int chequeNum = Integer.parseInt(tokens[1]);
		Cheque cheque = new Cheque();
		cheque.setIfscCode(ifsc);
		cheque.setChequeNo(chequeNum);

		return cheque;
	}

	//Cheque type converted into String type
	@Override
	public String toString(Cheque cheque) {
		return cheque.getIfscCode() + "-" + cheque.getChequeNo();
	}

}
