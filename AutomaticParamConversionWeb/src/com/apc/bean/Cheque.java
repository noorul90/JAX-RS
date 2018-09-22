package com.apc.bean;

public class Cheque {
	
	private String ifscCode;
	private int chequeNo;
	
	//single-arg string param constructor
	/*public Cheque(String ifscCode) {
		this.ifscCode = ifscCode;
		String[] tokens=null;
		tokens=ifscCode.split("-");
		this.chequeNo=Integer.parseInt(tokens[0]);
		this.chequeType=tokens[1];
		this.ifscCode = tokens[2];
	}*/
	
	public int getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(int chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	
	public static Cheque valueOf(String chequeNum) {
		Cheque cheque = null;
		String[] tokens = null;
		tokens = chequeNum.split("-");
		String ifscCode = tokens[0];
		int chequeNo = Integer.parseInt(tokens[1]);

		cheque = new Cheque();
		cheque.setIfscCode(ifscCode);
		cheque.setChequeNo(chequeNo);

		return cheque;
	}
	
}
