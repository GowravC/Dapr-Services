package com.softtek;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// dapr run --app-id ServiceApp --app-port 8080 --resources-path src/main/resources/ -- java -jar target/OrderProcessingService-0.0.1-SNAPSHOT.jar
@SpringBootApplication
public class StateManagementDaprExampleApplication {
	private static final String DAPR_STATE_STORE = "statestore";
	private static String DAPR_HOST = System.getenv().getOrDefault("DAPR_HOST", "http://localhost");
	private static String DAPR_HTTP_PORT = System.getenv().getOrDefault("DAPR_HTTP_PORT", "3500");
	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofSeconds(10)).build();

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		SpringApplication.run(StateManagementDaprExampleApplication.class, args);

		URI baseUrl = new URI(DAPR_HOST + ":" + DAPR_HTTP_PORT);
		URI stateStoreUrl = new URI(baseUrl + "/v1.0/state/" + DAPR_STATE_STORE);
		for (int i = 1; i <= 100; i++) {
			int orderId = i;
			Order order = new Order(orderId);
			State state = new State(String.valueOf(orderId), order);
			State[] payload = new State[] { state };
			ObjectMapper objectMapper = new ObjectMapper();

			// Save state into a state store
			HttpRequest request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(payload)))
					.uri(stateStoreUrl).build();
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Saving order: " + order.getOrderId());

			// Get state from a state store
			URI getStateURL = new URI(baseUrl + "/v1.0/state/" + DAPR_STATE_STORE + "/" + String.valueOf(orderId));
			request = HttpRequest.newBuilder().GET().uri(getStateURL).build();

			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Order saved: " + response.body());

			// Delete state from the state store
			URI deleteStateURI = new URI(baseUrl + "/v1.0/state/" + DAPR_STATE_STORE + "/" + String.valueOf(orderId));
			request = HttpRequest.newBuilder().DELETE().uri(deleteStateURI).build();
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("Deleting order: " + order.getOrderId());
			System.out.println("Deletion Status code :" + response.statusCode());
			TimeUnit.MILLISECONDS.sleep(1000);
		}
	}

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Order {
	private int orderId;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class State {

	private String key;
	private Order value;
}
