package com.rich.dapr.client;

import io.dapr.client.DaprClient;
import io.dapr.client.domain.HttpExtension;
import io.dapr.exceptions.DaprException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderSdkClient {

	@Autowired
	private DaprClient daprClient;

	/**
	 * Identifier in Dapr for the service this client will invoke.
	 */
	private static final String SERVICE_APP_ID = "providerApp";

	public String getOrders() {
		byte[] response = null;
		try {
			response = daprClient.invokeMethod(SERVICE_APP_ID, "info", null, HttpExtension.GET, null, byte[].class)
					.block();
		} catch (DaprException exception) {
			log.error("Dapr error code: {}, message: {}", exception.getErrorCode(), exception.getMessage());
			return "";
		}
		String result = new String(response);
		log.info("returned by sdk {}", result);

		return result;
	}
}
