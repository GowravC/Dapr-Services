package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//dapr run --app-id ServiceApp --app-port 8080 --resources-path src/main/resources/ -- java -jar target/Dapr-State-Management-0.0.1-SNAPSHOT.jar

@SpringBootApplication
public class DaprStateManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaprStateManagementApplication.class, args);
	}

}
