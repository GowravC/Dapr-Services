Service  invocation Using Producer and Consumer
Pre-requisites
* Dapr and Dapr CLI.
* Java JDK 11 (or greater):
o Microsoft JDK 11
o OpenJDK 11
* Eclipse / STS(Spring Tool Suite)
* Apache Maven version 3.x.

Step 1: Install Dapr CLI

Download the MSI package dapr.msi from latest Dapr release.

Step 2: Initialize Dapr without Containers

Run the following command to initialize Dapr:
dapr init --slim
This will create a default configuration file in your current directory.

Verify Dapr Version
dapr --version

Step 3: Start Dapr

Run the following command to start Dapr:
dapr start
This will start the Dapr runtime on your PC.

Step 4: Verify Dapr Installation
Run the following command to verify that Dapr is running:
dapr status
This should display the status of the Dapr runtime.
				

Clone this repository:
git clone https://github.com/dapr/Dapr-Services.git
cd Dapr-Services

Project Setup:
Import the Project Folder into STS workspace
Clean and install both Producer and Consumer apps using maven clean and maven install option


Run using command prompt:
Run the MS App in CMD - dapr run --app-id "app-id" --app-port "app-port" -- java -jar "Specify jar file location“

Command to run Provider App –  dapr run --app-id providerApp --app-port 9900 -- java -jar target/SB-MS-Dapr-Provider-0.0.1-SNAPSHOT.jar
•This App provides Bill Amount and Payment Type by consuming data from Producer App.
•Used Dapr to get data from Producer App.
Command to run Consumer App - dapr run --app-id springapp --app-port 8080 -- java -jar target/spring-dapr-0.0.1.jar
	This App consumes data from provider app and gives the output

