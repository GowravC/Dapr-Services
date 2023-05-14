package com.softtek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.model.Billing;
import com.softtek.service.BillingService;

@RestController
public class BillingServiceController {

	@Autowired
	private BillingService billService;

	@GetMapping(path = "/generate-bill")
	public ResponseEntity<?> GenerateBillDetails() {
		try {
			Billing BillDetails = billService.generateBillDetails();
			return new ResponseEntity<Billing>(BillDetails, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in genrating the " + "Bill Details",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}