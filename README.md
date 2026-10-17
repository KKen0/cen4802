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

## Unit Testing

This project uses JUnit 5 for automated unit testing.

The unit tests are located in:

src/test/java/org/example/cen4802/PurchaseCalculatorTest.java

The tests verify:

- Purchase subtotal calculations
- 6.5% sales tax calculations
- Final total calculations
- Decimal-price input scenarios

To execute the unit tests separately, run:

mvn test

To run the complete automated build, including the unit tests, run:

mvn clean package

During the Maven build, the JUnit tests are executed automatically before the
application is packaged as a WAR file.

For Assignment 3, a deliberate change was made to the sales tax rate to verify
that the tests could detect incorrect application behavior. After the test
failure was identified, the correct 6.5% tax rate was restored and the complete
test suite passed successfully.

## Continuous Integration

This project uses GitHub Actions for continuous integration. The workflow is stored in `.github/workflows/ci.yml` and runs automatically when changes are pushed to the `main` branch.

The CI workflow checks out the repository, sets up Java 21, and runs:

mvn -B clean package

This command compiles the application, runs the JUnit tests, and packages the project as a WAR file. After a successful build, the WAR file is uploaded as a GitHub Actions artifact.

## Application Containerization

This project uses Docker to run the Java web application inside a container.

The application is first built and packaged using Maven:

mvn clean package

This command compiles the project, runs the JUnit tests, and produces the WAR file used by the Docker image.

The Docker image is built with:

docker build -t cen4802-app .

The container is started with:

docker run -d --name cen4802-container -p 8081:8080 cen4802-app

The application can then be accessed at:

http://localhost:8081/cen4802/

## Midterm Project - Integrated CI and Containerization Workflow

For the Midterm Project, the Purchase Calculator was updated with a new
discount calculation feature.

The user can enter an item price, quantity, and discount percentage. The
application calculates:

- Purchase subtotal
- Discount amount
- Sales tax on the discounted subtotal
- Final total

Additional JUnit tests were added to verify the discount calculation and the
final total after the discount is applied.

The project uses the existing Maven build process to compile the application,
run the automated unit tests, and package the application as a WAR file.

GitHub Actions is used for Continuous Integration. The CI workflow automatically
builds, tests, and packages the application from the version-controlled source.

The Midterm Project also integrates Docker with the CI workflow so that a
container image is created only after the Maven build and unit tests complete
successfully.

The complete workflow is:

Source Code -> Maven Build -> Unit Tests -> WAR Package -> Docker Image ->
Running Container

## Assignment 6 - Kubernetes Application Deployment

For Assignment 6, the Purchase Calculator was deployed to a local Kubernetes
cluster provided by Docker Desktop.

The deployment uses the Docker image created through the previous CI workflow:

`cen4802-app:ec933e7e1d8743a662fbac275086dc173fc5c409`

The Kubernetes configuration is stored in:

- `k8s-deployment.yaml`
- `k8s-service.yaml`

The deployment starts with one application replica using container port 8080.

To deploy the application:

```bash
kubectl apply -f k8s-deployment.yaml
kubectl apply -f k8s-service.yaml