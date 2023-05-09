package com.rich.dapr.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rich.dapr.client.OrderSdkClient;

@RequestMapping("/shopping")
@RestController
public class CustomerController {

	@Autowired
	private OrderSdkClient orderSdkClient;

	@GetMapping(value = "/deatils")
	public String getOrders() {
		String resultBody = orderSdkClient.getOrders();// contains Provider Ms Result
		System.out.println(resultBody);
		String billingInfo = "Bill Amount :: " + new Random().nextInt(10000);// Consumer Msresult
		return billingInfo + "........" + resultBody;// contains Provider and Consumer
	}

}