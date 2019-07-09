package com.helpezee.fix.adapter;

import quickfix.fix42.NewOrderSingle;

import com.helpezee.fix.model.LifeCycleManagerModel;

public interface PhysicalSettlementAdapter {
	
	NewOrderSingle convertNewOrderSingle(LifeCycleManagerModel lifeCycleManagerModel);

}
