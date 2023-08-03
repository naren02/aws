# aws lambda
Set up AWS CLI and Configure Credentials:

**Install AWS CLI on your local machine.**
Configure AWS CLI with your AWS Access Key ID and Secret Access Key using the aws configure command.
****Set up Java Development Environment:
****
Install Java Development Kit (JDK) on your local machine if you haven't already.
Set the JAVA_HOME environment variable to point to your JDK installation directory.
**Set up Apache Maven:**

Install Apache Maven on your local machine if you haven't already.
Set the MAVEN_HOME environment variable to point to your Maven installation directory.
**Create a New Maven Project:**

Open a terminal or command prompt.
Use Maven to create a new Java project:
      mvn archetype:generate -DgroupId=com.example -DartifactId=my-lambda-function -DarchetypeArtifactId=maven-archetype-quickstart - 
      DinteractiveMode=false
This will create a new Maven project with the specified group ID (com.example) and artifact ID (my-lambda-function).

**Add AWS Lambda Dependencies:**
Open the pom.xml file in the project folder.
Add the AWS Lambda Java Core and AWS SDK for Java Lambda dependencies:
    
    <dependencies>
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-lambda-java-core</artifactId>
        <version>1.2.1</version>
    </dependency>
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-lambda-java-events</artifactId>
        <version>3.10.0</version>
    </dependency>
</dependencies>

**Implement the Lambda Function:**
Create a Java class that implements the RequestHandler interface from the aws-lambda-java-core dependency.
The handleRequest method in your class will be the entry point for your Lambda function.
Example Lambda function class:

  package com.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class MyLambdaFunction implements RequestHandler<RequestClass, ResponseClass> {

    @Override
    public ResponseClass handleRequest(RequestClass input, Context context) {
        // Your Lambda function logic here
        ResponseClass response = new ResponseClass();
        response.setMessage("Hello, " + input.getName() + "!");
        return response;
    }
}
Note: RequestClass and ResponseClass are POJO classes representing the input and output data for your Lambda function.

**Build the Maven Project:**
In the terminal, navigate to the project folder containing the pom.xml file.
Run the following command to build the Maven project:
                mvn clean package
This will compile your Java code and package it into a JAR file in the target folder.

**Deploy the Lambda Function:**
Use the AWS CLI to create the Lambda function on AWS:

      aws lambda create-function --function-name MyLambdaFunction --runtime java11 --role <your_lambda_role_arn> --handler com.example.MyLambdaFunction::handleRequest --zip-file fileb://target/my-lambda-function.jar

Replace <your_lambda_role_arn> with the ARN of the IAM role that allows your Lambda function to access AWS resources.

**Test the Lambda Function:**
Use the AWS CLI to invoke your Lambda function:
  
    aws lambda invoke --function-name MyLambdaFunction --payload '{"name": "John"}' output.txt

This will invoke your Lambda function with the input {"name": "John"} and store the response in output.txt.

That's it! You have now created an AWS Lambda function using Java and Maven.

