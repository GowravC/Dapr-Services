package com.rich.dapr.model;

import lombok.Data;

@Data
public class Billing {
	private Long billId;
	private Double totalAmt;
	private String paymentMode;
}
