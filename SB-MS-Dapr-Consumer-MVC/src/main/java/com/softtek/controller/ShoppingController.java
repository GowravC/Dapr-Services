package com.softtek.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.softtek.enitity.ShoppingDeatils;
import com.softtek.service.ShoppingService;

@Controller
public class ShoppingController {

	@Autowired
	private ShoppingService shoppingService;

	@GetMapping(value = "/shopping-details")
	public String GetShoppingDetails(Map<String, Object> map) {
		ShoppingDeatils shoppingDetails = shoppingService.GenerateShoppingDetails();
		map.put("shop", shoppingDetails);
		return "shopping";

	}

	@GetMapping("/")
	public String welcome() {
		System.out.println("welcome");
		return "welcome";
	}

}