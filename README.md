# CEN4802 - Purchase Calculator

Author: Kaveen Amin

## Description

The Purchase Calculator is a Java web application that allows a user to enter
an item price and quantity and calculates the purchase subtotal, sales tax,
and final total.

## Technologies Used

- Java
- Jakarta Servlet
- Maven
- Apache Tomcat

## Build Process

This project uses Maven to automate the build and packaging process.

To build the application from the command line, run:

mvn clean package

Maven compiles the project and packages the application as a WAR file.

The generated artifact is located at:

target/cen4802-1.0-SNAPSHOT.war

## Running the Application

The generated WAR file can be deployed to the Apache Tomcat `webapps`
directory.

Tomcat can then be started from the command line using:

catalina.bat run

After Tomcat starts, the application can be accessed in a web browser at:

http://localhost:8080/cen4802/

## Automated Build Modification

For Assignment 2, the application was modified and rebuilt using Maven.
The newly generated WAR artifact was redeployed to Apache Tomcat to verify
that the updated application reflected the source-code changes.
