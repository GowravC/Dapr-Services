package com.softtek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingServiceController {

	@GetMapping(path = "/info")
	public String paymentTypeInfo() {
		return "We accept Card Payment, UPI Payment, Netbanking";
	}
}