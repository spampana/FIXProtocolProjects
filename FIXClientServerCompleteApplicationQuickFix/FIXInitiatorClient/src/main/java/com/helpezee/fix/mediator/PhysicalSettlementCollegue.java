package com.helpezee.fix.mediator;

import com.helpezee.fix.model.LifeCycleManagerModel;

import quickfix.fix42.ExecutionReport;

public abstract class PhysicalSettlementCollegue {	
	
	protected PhysicalSettlementMediator physicalSettlementMediator;
         
    public PhysicalSettlementCollegue(PhysicalSettlementMediator physicalSettlementMediator){
        this.physicalSettlementMediator=physicalSettlementMediator;       
    }
     
    public abstract ExecutionReport sendPhysicalSettlementOrder(LifeCycleManagerModel lifeCycleManagerModel);     
    

}
