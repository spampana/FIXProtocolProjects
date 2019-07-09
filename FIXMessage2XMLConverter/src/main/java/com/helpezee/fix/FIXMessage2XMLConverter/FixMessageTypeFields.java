package com.helpezee.fix.FIXMessage2XMLConverter;

public enum FixMessageTypeFields {

	MSGTYPE(35),
	QTY(32),
	PRICE(31),
	EXECTRANSTYPE(20),
	EXECTYPE(150),
	EXECID(17),
	ORDERID(37),
	SIDE(54),
	UNDERLIERSTOCKSYMBOL(55),
	TRANSACTTIME(60),
	SENDINGTIME(52),
	FUTSETTDATE(64),
	SECURIRYTYPE(167),
	SEND(10335),
	TRADERID(11107),
	LEGALENTITIY(111320),
	ACCOUNTNAME(111321),
	
	//Assigned values	
	EXECTYPEVALUE(0),
	EXECTRANSTYPEVALUE(0),	
	MSGTYPEVALUE("D"),
	SECURITYTYPEVALUE("CS"),
	BUY("BUY"),
	SELL("SELL"),
	SENDVALUE("Y");
	
	private int value = 0;
	private String assignedValue = null;
	
	FixMessageTypeFields(int value) {
		this.value = value;
	}
	
	FixMessageTypeFields(String messageValue) {
		this.assignedValue = messageValue;
	}

	public int getValue() {
		return value;
	}

	public String getAssignedValue() {
		return assignedValue;
	}
	
}