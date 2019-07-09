package com.helpezee.fix.mediator;

import com.helpezee.fix.model.LifeCycleManagerModel;

import quickfix.fix42.ExecutionReport;



public class PhysicalSettlementCollegueImpl extends PhysicalSettlementCollegue{

	public PhysicalSettlementCollegueImpl(PhysicalSettlementMediator physicalSettlementMediator) {
		super(physicalSettlementMediator);		
	}

	@Override
	public ExecutionReport sendPhysicalSettlementOrder(LifeCycleManagerModel lifeCycleManagerModel) {
		return physicalSettlementMediator.sendPhysicalSettlementOrder(lifeCycleManagerModel);
	}

}
