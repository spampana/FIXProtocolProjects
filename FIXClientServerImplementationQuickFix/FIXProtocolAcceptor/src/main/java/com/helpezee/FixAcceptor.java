package com.helpezee;

import java.io.File;

import quickfix.Application;
import quickfix.DefaultMessageFactory;
import quickfix.DoNotSend;
import quickfix.FieldNotFound;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.MessageCracker;
import quickfix.RejectLogon;
import quickfix.ScreenLogFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;
import quickfix.SocketAcceptor;
import quickfix.UnsupportedMessageType;
import quickfix.field.AvgPx;
import quickfix.field.ClOrdID;
import quickfix.field.CumQty;
import quickfix.field.ExecID;
import quickfix.field.ExecTransType;
import quickfix.field.ExecType;
import quickfix.field.Headline;
import quickfix.field.LeavesQty;
import quickfix.field.OrdStatus;
import quickfix.field.OrdType;
import quickfix.field.OrderID;
import quickfix.field.OrderQty;
import quickfix.field.Price;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.fix42.ExecutionReport;
import quickfix.fix42.NewOrderSingle;
import quickfix.fix42.News;

public class FixAcceptor extends MessageCracker implements Application {

	public static void main(String[] args) {
		try {
			File file = new File("./config/acceptor.cfg");
			System.out.println(file.getAbsolutePath());
			SessionSettings settings = new SessionSettings("./config/acceptor.cfg");
			FixAcceptor acceptor = new FixAcceptor();
			ScreenLogFactory screenLogFactory = new ScreenLogFactory(settings);
			DefaultMessageFactory messageFactory = new DefaultMessageFactory();
			FileStoreFactory fileStoreFactory = new FileStoreFactory(settings);
			SocketAcceptor socketAcceptor = new SocketAcceptor(acceptor,fileStoreFactory, settings, screenLogFactory,messageFactory);
			socketAcceptor.start();
			System.out.println("press any key to stop the FIX Acceptor Server....s");
			System.in.read();
			socketAcceptor.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fromAdmin(Message arg0, SessionID arg1) throws FieldNotFound,
			IncorrectDataFormat, IncorrectTagValue, RejectLogon {
		System.out.println("fromAdmin " + arg0);
	}

	public void fromApp(Message message, SessionID sessionID)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			UnsupportedMessageType {
		crack(message, sessionID);

	}

	public void onCreate(SessionID arg0) {
	}

	public void onLogon(SessionID sessionID) {
		System.out.println("onLogon of "+sessionID);

	}

	public void onLogout(SessionID arg0) {

	}

	public void toAdmin(Message arg0, SessionID arg1) {
	}

	public void toApp(Message arg0, SessionID arg1) throws DoNotSend {
	}

	//@Override
	public void onMessage(NewOrderSingle order, SessionID sessionID)
			throws FieldNotFound, UnsupportedMessageType, IncorrectTagValue {
		// sending some news to the client.
		System.out.println("Inside onmessage method");
		try {
			Session.sendToTarget(new News(new Headline("Hello to OTC Expiration")), sessionID);
		} catch (SessionNotFound e) {
			e.printStackTrace();
		}
		Symbol symbol = new Symbol();
		Side side = new Side();
		OrdType ordType = new OrdType();
		OrderQty orderQty = new OrderQty();
		Price price = new Price();
		ClOrdID clOrdID = new ClOrdID();

		order.get(symbol);
		order.get(side);
		order.get(orderQty);
		order.get(price);
		order.get(clOrdID);
		order.get(ordType);


		ExecutionReport executionReport = new ExecutionReport(
				getOrderIDCounter(), getExecutionIDCounter(),
				new ExecTransType(ExecTransType.NEW), new ExecType(
						ExecType.FILL), new OrdStatus(OrdStatus.FILLED),
				symbol, side, new LeavesQty(0),
				new CumQty(orderQty.getValue()), new AvgPx(price.getValue()));
		executionReport.set(clOrdID);
		executionReport.set(orderQty);
		try {
			Session.sendToTarget(executionReport, sessionID);
			System.out.println("NewOrderSingle Execution  Completed...");
		} catch (SessionNotFound ex) {
			ex.printStackTrace();
			System.out.println("Error during order execution" + ex.getMessage());
		}
	}

	private int orderIDCounter;
	private int executionIDCounter;

	public OrderID getOrderIDCounter() {
		orderIDCounter++;
		return new OrderID(String.valueOf(orderIDCounter));
	}

	public ExecID getExecutionIDCounter() {
		executionIDCounter++;
		return new ExecID(String.valueOf(executionIDCounter));
	}
}
