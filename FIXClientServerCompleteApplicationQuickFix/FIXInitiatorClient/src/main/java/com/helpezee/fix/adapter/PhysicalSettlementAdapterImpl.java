package com.helpezee.fix.adapter;

import java.util.Date;

import com.helpezee.fix.model.LifeCycleManagerModel;

import quickfix.field.ClOrdID;
import quickfix.field.HandlInst;
import quickfix.field.OrdType;
import quickfix.field.OrderQty;
import quickfix.field.Price;
import quickfix.field.Side;
import quickfix.field.Symbol;
import quickfix.field.TransactTime;
import quickfix.fix42.NewOrderSingle;

public class PhysicalSettlementAdapterImpl implements PhysicalSettlementAdapter{

	public NewOrderSingle convertNewOrderSingle(LifeCycleManagerModel lifeCycleManagerModel) {
		
		NewOrderSingle order = new NewOrderSingle(new ClOrdID(lifeCycleManagerModel.getOrderID()),
				new HandlInst(HandlInst.MANUAL_ORDER), new Symbol(lifeCycleManagerModel.getUnderlier()),
				new Side(Side.BUY), new TransactTime(new Date()), new OrdType(OrdType.MARKET));
		
		order.set(new OrderQty(lifeCycleManagerModel.getQuantity()));
		order.set(new Price(lifeCycleManagerModel.getUndPrice()));
		return order;
	}

}
