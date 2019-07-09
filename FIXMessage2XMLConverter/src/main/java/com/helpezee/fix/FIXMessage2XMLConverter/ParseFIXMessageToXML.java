package com.helpezee.fix.FIXMessage2XMLConverter;

import quickfix.Message;
import quickfix.MessageParseError;

public class ParseFIXMessageToXML {

	public static void main(String[] args) throws MessageParseError {

		Message fixMessage = CreateFixMessage.getFixMessage();
		System.out.println(fixMessage.toXML());

	}

}
