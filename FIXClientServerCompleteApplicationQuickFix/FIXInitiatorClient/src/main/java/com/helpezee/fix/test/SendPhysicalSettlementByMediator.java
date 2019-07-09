package com.helpezee.fix.test;

import com.helpezee.fix.mediator.PhysicalSettlementCollegue;
import com.helpezee.fix.mediator.PhysicalSettlementCollegueImpl;
import com.helpezee.fix.mediator.PhysicalSettlementMediator;
import com.helpezee.fix.mediator.PhysicalSettlementMediatorImpl;
import com.helpezee.fix.model.LifeCycleManagerModel;

import quickfix.fix42.ExecutionReport;

public class SendPhysicalSettlementByMediator {

	public static void main(String[] args) {
		
		PhysicalSettlementMediator physicalSettlementMediator = new PhysicalSettlementMediatorImpl();
		PhysicalSettlementCollegue fixMessageSenderCollegue = new PhysicalSettlementCollegueImpl(physicalSettlementMediator);
		LifeCycleManagerModel lifeCycleManagerModel = new LifeCycleManagerModel();
		lifeCycleManagerModel.setOrderID("123456");
		lifeCycleManagerModel.setUnderlier("AAPL");
		lifeCycleManagerModel.setQuantity(123.0);
		lifeCycleManagerModel.setUndPrice(369.36);
		ExecutionReport acknowledgement = fixMessageSenderCollegue.sendPhysicalSettlementOrder(lifeCycleManagerModel);
		System.out.println("Acknowledgement received: --> "+acknowledgement);
	}

}
