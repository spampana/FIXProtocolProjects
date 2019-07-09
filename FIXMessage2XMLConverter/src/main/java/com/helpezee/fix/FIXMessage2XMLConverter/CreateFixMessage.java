package com.helpezee.fix.FIXMessage2XMLConverter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import quickfix.DoubleField;
import quickfix.IntField;
import quickfix.Message;
import quickfix.StringField;

public class CreateFixMessage {

	public static void main(String[] args) {

		Message fixMessage = getFixMessage();
		System.out.println("Origional FIX message:-->" + fixMessage + "\n");

	}

	public static Message getFixMessage() {

		Message message = new Message();

		StringField msgType = new StringField(FixMessageTypeFields.MSGTYPE.getValue(),
				FixMessageTypeFields.MSGTYPEVALUE.getAssignedValue());
		DoubleField qty = new DoubleField(FixMessageTypeFields.QTY.getValue(), 100.00);
		DoubleField price = new DoubleField(FixMessageTypeFields.PRICE.getValue(), 59.99);
		IntField execTransType = new IntField(FixMessageTypeFields.EXECTRANSTYPE.getValue(),
				FixMessageTypeFields.EXECTRANSTYPEVALUE.getValue());
		IntField execType = new IntField(FixMessageTypeFields.EXECTYPE.getValue(),
				FixMessageTypeFields.EXECTYPEVALUE.getValue());
		StringField orderID = new StringField(FixMessageTypeFields.ORDERID.getValue(), "123456789");
		BigDecimal origQuantity = BigDecimal.valueOf(100.00);
		String sideTemp = origQuantity.compareTo(BigDecimal.valueOf(0.0)) < 0
				? FixMessageTypeFields.BUY.getAssignedValue()
				: FixMessageTypeFields.SELL.getAssignedValue();
		StringField side = new StringField(FixMessageTypeFields.SIDE.getValue(), sideTemp);
		StringField underlierStockSymbol = new StringField(FixMessageTypeFields.UNDERLIERSTOCKSYMBOL.getValue(),
				".SPX");
		StringField transactTime = new StringField(FixMessageTypeFields.TRANSACTTIME.getValue(),
				LocalDateTime.now().toString());
		StringField sendingTime = new StringField(FixMessageTypeFields.SENDINGTIME.getValue(),
				LocalDateTime.now().toString());
		StringField futSettDate = new StringField(FixMessageTypeFields.FUTSETTDATE.getValue(),
				LocalDateTime.now().plusDays(2).toString());
		StringField securityType = new StringField(FixMessageTypeFields.SECURIRYTYPE.getValue(),
				FixMessageTypeFields.SECURITYTYPEVALUE.getAssignedValue());
		StringField send = new StringField(FixMessageTypeFields.SEND.getValue(),
				FixMessageTypeFields.SENDVALUE.getAssignedValue());
		StringField traderID = new StringField(FixMessageTypeFields.TRADERID.getValue(), "Java Honk");
		StringField legalEntity = new StringField(FixMessageTypeFields.LEGALENTITIY.getValue(), "Java Honk");
		StringField accountName = new StringField(FixMessageTypeFields.ACCOUNTNAME.getValue(), "123456");
		StringField execID = new StringField(FixMessageTypeFields.EXECID.getValue(), "123654987");

		message.setField(msgType);
		message.setField(qty);
		message.setField(price);
		message.setField(execTransType);
		message.setField(execType);
		message.setField(orderID);
		message.setField(side);
		message.setField(underlierStockSymbol);
		message.setField(transactTime);
		message.setField(sendingTime);
		message.setField(futSettDate);
		message.setField(securityType);
		message.setField(send);
		message.setField(traderID);
		message.setField(legalEntity);
		message.setField(accountName);
		message.setField(execID);

		return message;
	}

}
