package com.helpezee.fix.mediator;

import com.helpezee.fix.model.LifeCycleManagerModel;

import quickfix.fix42.ExecutionReport;


public interface PhysicalSettlementMediator {
	
	ExecutionReport sendPhysicalSettlementOrder(LifeCycleManagerModel lifeCycleManagerModel);

}
	