package com.helpezee.fix.mediator;

import java.util.ArrayList;

import com.helpezee.fix.adapter.PhysicalSettlementAdapter;
import com.helpezee.fix.adapter.PhysicalSettlementAdapterImpl;
import com.helpezee.fix.model.LifeCycleManagerModel;
import com.helpezee.fix.test.FixInitiatorStratup;

import quickfix.Session;
import quickfix.SessionID;
import quickfix.fix42.ExecutionReport;

public class PhysicalSettlementMediatorImpl implements
		PhysicalSettlementMediator {

	public ExecutionReport sendPhysicalSettlementOrder(LifeCycleManagerModel lifeCycleManagerModel) {
		
		try {

			ArrayList<SessionID> sessions = FixInitiatorStratup.getFixSession();
			
			PhysicalSettlementAdapter fixMessageAdapter = new PhysicalSettlementAdapterImpl();

			SessionID sessionID = sessions.get(0);
			System.out.println("Sending Order to Server");
			Session.sendToTarget(fixMessageAdapter.convertNewOrderSingle(lifeCycleManagerModel), sessionID);
			Thread.sleep(3000);
			System.out.println("Stoping socketInitiator");
			FixInitiatorStratup.stopFixInitiator();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return FixInitiatorStratup.getExecutionReport();

	}

}
