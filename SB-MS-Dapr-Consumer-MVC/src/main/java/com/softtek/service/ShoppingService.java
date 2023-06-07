package com.softtek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.client.BillSdkClient;
import com.softtek.enitity.ShoppingDeatils;

@Service
public class ShoppingService {

	@Autowired
	private BillSdkClient billSdkClient;

	public ShoppingDeatils GenerateShoppingDetails() {
		ShoppingDeatils shoppingDeatils = new ShoppingDeatils();
		shoppingDeatils.setCustomerName("Name of Customer");
		shoppingDeatils.setProducts(new String[] { "product 1", "product 2", "product 3" });
//		shoppingDeatils.setTotalAmt(1000.0);
//		shoppingDeatils.setPaymentMode("Card_Payment");
		shoppingDeatils.setTotalAmt(billSdkClient.getPaymentDeatils().getTotalAmt());
		shoppingDeatils.setPaymentMode(billSdkClient.getPaymentDeatils().getPaymentMode());
		return shoppingDeatils;
	}

}
