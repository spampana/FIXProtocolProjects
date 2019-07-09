package com.helpezee.fix.String2FixMessageConverter;


import quickfix.MessageParseError;
import quickfix.MessageUtils;
public class ParseFIXMessage {

	public static void main(String[] args) throws MessageParseError {
		
		String fixMessage = CreateFixMessage.getFixMessage().toString();
		
		System.out.println("Fix Message:  " + fixMessage);
		
		System.out.println(MessageUtils.getStringField(fixMessage, 8));
		System.out.println(MessageUtils.getStringField(fixMessage, 17));
		System.out.println(MessageUtils.getStringField(fixMessage, 20));
		System.out.println(MessageUtils.getStringField(fixMessage, 31));
		System.out.println(MessageUtils.getStringField(fixMessage, 32));
		System.out.println(MessageUtils.getStringField(fixMessage, 35));
		System.out.println(MessageUtils.getStringField(fixMessage, 37));
		System.out.println(MessageUtils.getStringField(fixMessage, 52));
		System.out.println(MessageUtils.getStringField(fixMessage, 54));
		System.out.println(MessageUtils.getStringField(fixMessage, 55));
		System.out.println(MessageUtils.getStringField(fixMessage, 60));
		System.out.println(MessageUtils.getStringField(fixMessage, 64));
		System.out.println(MessageUtils.getStringField(fixMessage, 150));		
		System.out.println(MessageUtils.getStringField(fixMessage, 167));
		System.out.println(MessageUtils.getStringField(fixMessage, 10335));
		System.out.println(MessageUtils.getStringField(fixMessage, 11107));
		System.out.println(MessageUtils.getStringField(fixMessage, 111320));
		System.out.println(MessageUtils.getStringField(fixMessage, 111321));
		System.out.println(MessageUtils.getStringField(fixMessage, 10));

	}

}
//http://javahonk.com/convert-string-fix-message/