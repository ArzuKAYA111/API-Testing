package com.hrms.API.steps.practice;
import io.cucumber.java.en.Given;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class TokenGenerationSteps {
	
	/**
	 * Storing token as static variable
	 */
	static String token;
	
	/**
	 * BaseURI
	 */
	String BaseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";
		
@Given("a JWT is created")
public void a_JWT_is_created() {
	
	// import static io.restassured.RestAssured.*;----> we need to import this in order to make given() worked
	
			RequestSpecification generateTokenRequest = given().header("Content-Type", "application/json")
					.body("{\r\n" +"  \"email\": \"kardn@gmail.com\",\r\n" +
			             "  \"password\": \"275346578\"\r\n" + "}");

			Response generateTokenresponse = generateTokenRequest.when().post("/generateToken.php");
		// generateTokenresponse.prettyPrint();
			
			/**
			 * Retrieving token from generate response body and concatenating "Bearer "
			 */
			 token="Bearer "+ generateTokenresponse.body().jsonPath().getString("token");
			 
			 /**
				 * Optional to print out token
				 */
		//	System.out.println(token);
		}

}