package com.hrms.API.steps.practice;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
/**
 * importing Junit packages
 */

import org.junit.Assert;
import org.junit.Test;
/**
 * Rest assured static packages
 */
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
//import org.apachi.hc.core5.http.ContentType

/**
 * This @FixMethodOrder(MethodSorters.NAME_ASCENDING) will execute @Test annotation
 *  in ascending alphabetical order
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardcodedExamples_1 {
	/**
	 * Rest Assured 
 * given - prepare our request
 * when  - we are making the call to the endpoint
 * Then validating
	 * 
	 */
static String baseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";//it is not URI it is base of the URI    URI=baseurl+endpoint ...>http://18.232.148.34/syntaxapi/api/generateToken.php like that
String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUyOTY2MzMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTMzOTgzMywidXNlcklkIjoiNDgyIn0.E72FJdYi3Kqc_X9rqKc9ZKYZaKHC9Vf8xwp8r3vgejg";
static String employeeID;	
	
//Create an Employee
	@Test
public void aPOSTcreateEmployee() {
		
		
		RequestSpecification createEmployeeRequest=	given().header("Content-Type","application/json").header("Authorization",token).body("{\r\n" + 
				"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
				"  \"emp_lastname\": \"White\",\r\n" + 
				"  \"emp_middle_name\": \"Alex\",\r\n" + 
				"  \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
				"  \"emp_status\": \"Employee\",\r\n" + 
				"  \"emp_job_title\": \"Data Quality Manager\"\r\n" + 
				"}");
		/**
		 * Storing response into createdEmployeeResponse
		 */
	
		Response createEmployeeResponse=createEmployeeRequest.when().log().all().post("/createEmployee.php");
		/**
		 * Printing response using prettyPrint() method
		 */
		createEmployeeResponse.prettyPrint();
		
		/**
		 * jsonPath() to view response body which lets us get the employee ID
		 */
	employeeID=	createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
		
		System.out.println(employeeID);
		/**
		 * verify response status code 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		/**
		 * verify response body
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Alexsandra"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_middle_name", equalTo("Alex"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_lastname", equalTo("White"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_birthday", equalTo("2001-07-03"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_gender", equalTo("Female"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_job_title", equalTo("Data Quality Manager"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_status", equalTo("Employee"));
		
		//verfy Response Headers do not use assertThat()
		
		// getting headers and varyfing them ( we are not using assertThat it may not work, but i tried it worked)
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		
		createEmployeeResponse.then().assertThat().header("X-Powered-By", "PHP/7.2.18");
	}
//Get created Employee
	
@Test
public void bGETcreatedEmployee() {
	/**
	 * Preparing request for /getOneEmployee.php
	 * Using log().all() to see all information being sent with request we do not need also we can commnd out it 
	 */
	RequestSpecification getCreatedEmployeeRequest = given().header("Content-Type", "application/json")
			.header("Authorization", token).queryParam("employee_id", employeeID).log().all();
	/**
	 * Making call to retrieve created employee
	 */
	Response getCreatedEmployeeResponse = getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
	/**
	 * Printing response using prettyPrint()
	 */
	String response=getCreatedEmployeeResponse.prettyPrint();
	/**
	 * Storing response employeeID into empID which will be used for verification
	 * against stored global employee ID
	 */
	String empID = getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
	/**
	 * matching exact employeeID's
	 */
	boolean verifyingEmpoyeeIDsMatch = empID.equalsIgnoreCase(employeeID);
	
	System.out.println("Employee id is matching "+verifyingEmpoyeeIDsMatch);
	
	/**
	 * Asserting employee ID's match
	 */
	Assert.assertTrue(verifyingEmpoyeeIDsMatch);
	/**
	 * Verifying status code is 200
	 */
	getCreatedEmployeeResponse.then().assertThat().statusCode(200);
	
	// yukarida bunu baska sekilde yaptik line 88 de burada json path ile nasil yapiliyor onu ogrendik boyle yapmasak ta olur 
	/**
	 *Using  
	 */
	JsonPath js=new JsonPath(response);
	
	String emplID=js.getString("employee[0].employee_id");
	String firstName=js.getString("employee[0].emp_firstname");
	String middleName=js.getString("employee[0].emp_middle_name");
	String lastName=js.getString("employee[0].emp_lastname");
	String emp_bday=js.getString("employee[0].emp_birthday");
	String gender=js.getString("employee[0].emp_gender");
	String jobTitle=js.getString("employee[0].emp_job_title");
	String empStatus=js.getString("employee[0].emp_status");
	
	System.out.println(emplID);
	System.out.println(firstName);
	System.out.println(middleName);
	
	/**
	 * Verifying employee ID's match
	 * 
	 * we can use contains also but we want to exatly same ID
	 * also we can use ignorecase()
	 */
	Assert.assertTrue(emplID.contentEquals(employeeID));
	/** Verifying expected first name matches actual firstname */
	Assert.assertTrue(firstName.contentEquals("Alexsandra"));
	/** Verifying expected middle name matches actual middle name */
	Assert.assertTrue(middleName.contentEquals("Alex"));
	/** Verifying expected last name matches actual last name */
	Assert.assertTrue(lastName.contentEquals("White"));
	/** Verifying expected emp_bday matches actual emp_bday*/
	Assert.assertTrue(emp_bday.contentEquals("2001-07-03"));
	/** Verifying expected gender matches actual gender */
	Assert.assertTrue(gender.contentEquals("Female"));
	/** Verifying expected job Title matches actual job Title */
	Assert.assertTrue(jobTitle.contentEquals("Data Quality Manager"));
	/** Verifying expected employee Status matches actual employee Status */
	Assert.assertTrue(empStatus.contentEquals("Employee"));
	
	//second way of asserting 
	Assert.assertEquals(employeeID,emplID);
	Assert.assertEquals("Alexsandra",firstName);
	Assert.assertEquals("Alex",middleName);
	Assert.assertEquals("White",lastName);
	Assert.assertEquals("2001-07-03",emp_bday);
	Assert.assertEquals("Female",gender);
	Assert.assertEquals("Data Quality Manager",jobTitle);
	Assert.assertEquals("Employee",empStatus);	
}	
	
@Test
public void cGetAllEmployees() {
		
	RequestSpecification getAllEmployeesRequest	=given().header("Content-Type","application/json").header("Authorization",token);
	
	Response getAllEmployeesResponse=getAllEmployeesRequest.when().get("/getAllEmployees.php");
	/**Printing all employees */
	//getAllEmployeesResponse.prettyPrint();
	
	String allEmployees=getAllEmployeesResponse.body().asString();
	
	/**The below will pass but incorrect  */
	allEmployees.contains(employeeID);
	
	/**====Do searh=====  */
	//allEmployees.matches(employeeID);
	
	JsonPath js=new JsonPath(allEmployees);
	
	/**Retrieve size of Employees list */
int sizeOfList	=js.getInt("Employees.size()");
	
	System.out.println(sizeOfList);
	
/**Print all employee ID's  */
	
	for(int i=0;i<sizeOfList;i++) {
		
	String allEmployeeIDs=js.getString("Employees["+i+"].employee_id");
		
	//System.out.println(allEmployeeIDs);
	/** 
	 * 
	 * */
	
	if(allEmployeeIDs.contentEquals(employeeID));
	System.out.println("Employee ID :"+employeeID +" is present in body");
	String employeeFirstName=js.getString("Employees["+i+"].emp_firstname");
	System.out.println(employeeFirstName);
	
	break;
	}

}
@Test	
public void dPUTupdateCreatedEmployee() {
	
	RequestSpecification updateCreatedEmployeeRequest=given().header("Content-Type","application/json").header("Authorization",token).body("{\r\n" + 
			"  \"employee_id\": \""+employeeID+"\",\r\n" + 
			"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
			"  \"emp_lastname\": \"string\",\r\n" + 
			"  \"emp_middle_name\": \"Alex\",\r\n" + 
			"  \"emp_gender\": \"F\",\r\n" + 
			"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
			"  \"emp_status\": \"Super Contractor\",\r\n" + 
			"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
			"}");
	Response updateCreatedEmployeeResponse=updateCreatedEmployeeRequest.when().post("/updateEmployee.php");
	String response =updateCreatedEmployeeResponse.prettyPrint();
	//System.out.println(response); 
	
}
	
}
