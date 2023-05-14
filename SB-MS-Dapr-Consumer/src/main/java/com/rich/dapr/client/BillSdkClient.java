package com.rich.dapr.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rich.dapr.model.Billing;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import io.dapr.exceptions.DaprException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BillSdkClient {

	@Autowired
	private DaprClient daprClient;

	/**
	 * Identifier in Dapr for the service this client will invoke.
	 */
	private static final String SERVICE_APP_ID = "BillingServiceApp";

	public Billing getPaymentDeatils() {
		byte[] response = null;
		Billing billObj = new Billing();
		try {
			response = daprClient
					.invokeMethod(SERVICE_APP_ID, "generate-bill", null, HttpExtension.GET, null, byte[].class).block();
		} catch (DaprException exception) {
			log.error("Dapr error code: {}, message: {}", exception.getErrorCode(), exception.getMessage());
		}
		String result = new String(response);
		log.info("returned by sdk {}", result);
		ObjectMapper mapper = new ObjectMapper();
		try {
			billObj = mapper.readValue(result, Billing.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return billObj;
	}
}
