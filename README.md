# Dapr Service-to-service invocation Example

In this Example, we have create two java applications: a service application which exposes a method / endpoint and a client application which will invoke the method from the service using Dapr.
This example includes:

* BillingService (Exposes the method to be remotely accessed)
* ShoppingApp (Invokes the exposed method from BillingService)

Visit [this](https://docs.dapr.io/developing-applications/building-blocks/service-invocation/service-invocation-overview/) link for more information about Dapr and service invocation.
 
 ## Pre-requisites
 
* [Dapr and Dapr CLI](https://docs.dapr.io/getting-started/install-dapr/).
* Java JDK 11 (or greater):
    * [Microsoft JDK 11](https://docs.microsoft.com/en-us/java/openjdk/download#openjdk-11)
    * [Oracle JDK 11](https://www.oracle.com/technetwork/java/javase/downloads/index.html#JDK11)
    * [OpenJDK 11](https://jdk.java.net/11/)
* [Apache Maven](https://maven.apache.org/install.html) version 3.x.
* [Eclipse / STS (Spring Tool Suite)](https://spring.io/tools).

## NOTE
We are Running Dapr in self-hosted mode without Docker
* Initialize Dapr without containers
The Dapr CLI provides an option to initialize Dapr using slim init, without the default creation of a development environment with a dependency on Docker. To initialize Dapr with slim init, after installing the Dapr CLI, use the following command:

```sh
dapr init --slim
```

### Checking out the code

Clone this repository:

```sh
git clone https://github.com/dapr/Dapr-Services.git
cd Dapr-Services
```

### Run Java Billing Service App with Dapr

1. Import the SB-MS-Dapr-Provider MS Project into STS workspace and perform:
 * Right click on project -> `Run As` -> `Maven clean`
 * Right click on project -> `Run As` -> `Maven install`
 
or 

Navigate to `SB-MS-Dapr-Provider` directory and install dependencies:

```bash
cd ./SB-MS-Dapr-Provider
mvn clean install
```
  
2.  Open a new terminal window, navigate to `SB-MS-Dapr-Provider` directory and Run the Java Billing Service App with Dapr:

```bash
cd ./SB-MS-Dapr-Provider
dapr run --app-id BillingServiceApp --app-port 9900 -- java -jar target/SB-MS-Dapr-Provider-0.0.1-SNAPSHOT.jar
```

### Run Java Shopping App with Dapr

1. Import the SB-MS-Dapr-Consumer MS Project into STS workspace and perform:
 * Right click on project -> `Run As` -> `Maven clean`
 * Right click on project -> `Run As` -> `Maven install`
 
or 

Navigate to `SB-MS-Dapr-Consumer` directory and install dependencies:

```bash
cd ./SB-MS-Dapr-Consumer
mvn clean install
```
  
2.  Open a new terminal window, navigate to `SB-MS-Dapr-Consumer` directory and Run the Java Shopping App with Dapr:

```bash
cd ./SB-MS-Dapr-Consumer
dapr run --app-id ShoppingApp --app-port 8080 -- java -jar target/SB-MS-Dapr-Consumer-0.0.1.jar
```

## Now both Producer and Consumer MS running with Dapr, Endpoint or API of Consumer (invoking the endpoint of Producer through Dapr) can be tested in Postman:

### Postman 
* HttpExtension - `GET`
* API - `http://localhost:8080/shopping/shopping-details`

### Output:

```sh
{
    "customerName": "Name of Customer",
    "products": [
        "product 1",
        "product 2",
	"product 3"
    ],
    "totalAmt": <Random amount 70000 - 80000>,
    "paymentMode": "Card Payment"
}
```

## Cleanup

To stop the apps run (or press CTRL+C):


```bash
dapr stop --app-id BillingServiceApp
dapr stop --app-id ShoppingApp
```
