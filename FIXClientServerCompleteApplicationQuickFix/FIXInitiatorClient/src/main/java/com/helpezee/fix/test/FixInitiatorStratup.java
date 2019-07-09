package com.helpezee.fix.test;

import java.util.ArrayList;

import quickfix.ApplicationAdapter;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FieldNotFound;
import quickfix.FileStoreFactory;
import quickfix.IncorrectDataFormat;
import quickfix.IncorrectTagValue;
import quickfix.Message;
import quickfix.RejectLogon;
import quickfix.ScreenLogFactory;
import quickfix.SessionID;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;
import quickfix.UnsupportedMessageType;
import quickfix.field.ExecType;
import quickfix.fix42.ExecutionReport;

public class FixInitiatorStratup extends ApplicationAdapter {

	private SocketInitiator socketInitiator;
	private static FixInitiatorStratup fixIniator;
	static ExecutionReport executionReport;
	
	
	public static ArrayList<SessionID> getFixSession() throws ConfigError {
		
		fixIniator = new FixInitiatorStratup();
		SessionSettings sessionSettings = new SessionSettings("./config/initiator/initiator.cfg");
		ApplicationAdapter application = new FixInitiatorStratup();
		FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
		ScreenLogFactory screenLogFactory = new ScreenLogFactory(sessionSettings);
		DefaultMessageFactory defaultMessageFactory = new DefaultMessageFactory();
		fixIniator.socketInitiator = new SocketInitiator(application,fileStoreFactory, sessionSettings, screenLogFactory,defaultMessageFactory);
		fixIniator.socketInitiator.start();
		
		ArrayList<SessionID> sessions = fixIniator.socketInitiator.getSessions();
		return sessions;
		
	}

	@Override
	public void onLogon(SessionID sessionId) {
		super.onLogon(sessionId);
		System.out.println("Logon requested by client");
	}

	@Override
	public void fromAdmin(quickfix.Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			RejectLogon {
		super.fromAdmin(message, sessionId);
		System.out.println("Inside fromAdmin");
	}

	@Override
	public void onCreate(SessionID sessionId) {
		super.onCreate(sessionId);
		System.out.println("Inside onCreate");
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		if (null != this.socketInitiator) {
			this.socketInitiator.stop();
		}
	}

	@Override
	public void fromApp(Message message, SessionID sessionId)
			throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue,
			UnsupportedMessageType {

		if (message instanceof ExecutionReport) {
			ExecutionReport executionReport = (ExecutionReport) message;
			FixInitiatorStratup.executionReport = executionReport;
			try {
				ExecType executionType = (ExecType) executionReport.getExecType();
				System.out.println("Received execution below is response \n");
				System.out.println(executionType);
				System.out.println("Received execution report for the requested order from Exchange \n");
			} catch (FieldNotFound e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void stopFixInitiator(){		
		fixIniator.socketInitiator.stop();		
	}

	public static ExecutionReport getExecutionReport() {
		return executionReport;
	}

	public static void setExecutionReport(ExecutionReport executionReport) {
		FixInitiatorStratup.executionReport = executionReport;
	}
	
	
}
