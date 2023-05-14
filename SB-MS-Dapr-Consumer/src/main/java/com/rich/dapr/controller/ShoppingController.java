package com.rich.dapr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rich.dapr.model.ShoppingDeatils;
import com.rich.dapr.service.ShoppingService;

@RequestMapping("/shopping")
@RestController
public class ShoppingController {

@Autowired
private ShoppingService shoppingService;

@GetMapping(value = "/shopping-details")
public ResponseEntity<?> GetShoppingDetails() {
	try {
		ShoppingDeatils shoppingDetails = shoppingService.GenerateShoppingDetails();
		return new ResponseEntity<ShoppingDeatils>(shoppingDetails, HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Problem in genrating the Shopping Details",
				HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}