package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// --dapr-config ./dapr-actor-example.yaml 
//dapr run --app-id ServiceApp --app-port 8080 --config src/main/resources/dapr-actor-example.yaml -- java -jar target/Dapr-Actor-0.0.1-SNAPSHOT.jar


@SpringBootApplication
public class DaprActorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaprActorApplication.class, args);
	}

}
