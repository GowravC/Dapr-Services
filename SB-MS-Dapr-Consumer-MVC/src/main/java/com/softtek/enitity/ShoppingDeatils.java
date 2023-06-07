package com.softtek.enitity;

import lombok.Data;

@Data
public class ShoppingDeatils {

	private String customerName;
	private String[] products;
	private Double totalAmt;
	private String paymentMode;
}
