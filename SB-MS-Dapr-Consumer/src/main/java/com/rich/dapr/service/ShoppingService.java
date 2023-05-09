package com.rich.dapr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rich.dapr.client.BillSdkClient;
import com.rich.dapr.model.ShoppingDeatils;

@Service
public class ShoppingService {

	@Autowired
	private BillSdkClient billSdkClient;

	public ShoppingDeatils GenerateShoppingDetails() {
		ShoppingDeatils shoppingDeatils = new ShoppingDeatils();
		shoppingDeatils.setCustomerName("Gowrav");
		shoppingDeatils.setProducts(new String[] { "Samsung Galaxy S22+", "Samsung 25W Travel Adapter" });
		shoppingDeatils.setTotalAmt(billSdkClient.getPaymentDeatils().getTotalAmt());
		shoppingDeatils.setPaymentMode(billSdkClient.getPaymentDeatils().getPaymentMode());
		return shoppingDeatils;
	}

}
