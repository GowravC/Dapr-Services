package com.softtek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 1. Build and install jars:
 * mvn clean install
 * 2. Run the Application in dapr(cmd):
 * dapr run --app-id ShoppingApp --app-port 4044 -- java -jar target/SB-MS-Dapr-Consumer-MVC-0.0.1-SNAPSHOT.war
 * {dapr run --app-id "app-id" --app-port "app-port" -- java -jar "Specify jar file location"}
 */
@SpringBootApplication
public class SBMSDaprConsumerMVCApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBMSDaprConsumerMVCApplication.class, args);
	}

}
