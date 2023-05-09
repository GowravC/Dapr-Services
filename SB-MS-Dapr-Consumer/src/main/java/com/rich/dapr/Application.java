package com.rich.dapr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1. Build and install jars:
 * mvn clean install
 * 2. Run the Application in dapr(cmd):
 * dapr run --app-id ShoppingApp --app-port 8080 -- java -jar target/SB-MS-Dapr-Consumer-0.0.1.jar
 * {dapr run --app-id "app-id" --app-port "app-port" -- java -jar "Specify jar file location"}
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
