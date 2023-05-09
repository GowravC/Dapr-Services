package com.softtek.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.softtek.model.Billing;

@Service
public class BillingService {

	public Billing generateBillDetails() {
		Random ran = new Random();
		Billing billing = new Billing();
		billing.setBillId(ran.nextLong(100));
		billing.setTotalAmt(ran.nextDouble(80000 - 70000) + 70000);
		billing.setPaymentMode("Card Payment");
		return billing;
	}
}
