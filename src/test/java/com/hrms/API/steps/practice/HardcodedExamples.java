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
public class HardcodedExamples {
	/**
	 * Rest Assured 
 * given - prepare our request
 * when  - we are making the call to the endpoint
 * Then validating
	 * 
	 */
static String baseURI=RestAssured.baseURI="http://18.232.148.34/syntaxapi/api";//it is not URI it is base of the URI    URI=baseurl+endpoint ...>http://18.232.148.34/syntaxapi/api/generateToken.php like that
static String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTU2ODkzMTgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTczMjUxOCwidXNlcklkIjoiNDgyIn0.jSUeHcTu4Etb8P80SBkh7XcksPv879nR9KASgm42cLs";
public static String employeeID;	

public void sampleTestNotes() { //this is only for information about API aotomation
	/**
	 * BaseURI for all calls
	 */

	RestAssured.baseURI = "http://18.232.148.34/syntaxapi/api";

	/**
	 * JWT required for all calls - expires every 12 hours
	 */
	String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTUxNjg1NjAsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU5NTIxMTc2MCwidXNlcklkIjoiNjQ1In0.huJh3_deVDC49u1tP55dxMic1zfMxOEohdurkOUSzlk";

	/**
	 * Preparing /getOneEmployee.php request
	 */
	RequestSpecification getOneEmployeeRequest = given().header("Content-Type", "application/json")
			.header("Authorization", token).queryParam("employee_id", "16490A"); // .log().all();

	/**
	 * Storing response
	 */
	Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");

	/**
	 * Two ways to print response prettyPrint() method converts JSON object into
	 * String and prints - no need to SOP
	 */
	getOneEmployeeResponse.prettyPrint();
	// String response = getOneEmployeeResponse.body().asString();
	// System.out.println(response);

	/**
	 * Verifying response status code is 200
	 */
	getOneEmployeeResponse.then().assertThat().statusCode(200);

}
	
//Create an Employee
	@Test
public void aPOSTcreateEmployee() {
		System.out.println(".......................... .......... a POST Create Employee ................................");
		
		/**
		 * Preparing request for /createEmployee.php
		 */
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
		createEmployeeResponse.prettyPrint(); //convert json to String  Prints as a string on the console
		
		/**
		 * jsonPath() to view response body which lets us get the employee ID We store
		 * employee ID as a global variable so that we may we use it with our other
		 * calls
		 * 
		 */
	employeeID=	createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
	
	/** optional to print employee ID */
		System.out.println(employeeID);
		/**
		 * verify response status code 201
		 */
		createEmployeeResponse.then().assertThat().statusCode(201);
		
		/**
		 * Verifying message using equalTo() method - manually import static package
		 * import static org.hamcrest.Matchers.*;
		 */
		createEmployeeResponse.then().assertThat().body("Message", equalTo("Entry Created"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Alexsandra"));  //asagida aynisi var
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_middle_name", equalTo("Alex"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_lastname", equalTo("White"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_birthday", equalTo("2001-07-03"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_gender", equalTo("Female"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_job_title", equalTo("Data Quality Manager"));
		createEmployeeResponse.then().assertThat().body("Employee[0].emp_status", equalTo("Employee"));
		
		//verfy Response Headers do not use assertThat()
		
		// getting headers and varyfing them ( we are not using assertThat it may not work, but i tried it worked)
		createEmployeeResponse.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
		
		createEmployeeResponse.then().assertThat().header("X-Powered-By", "PHP/7.2.18");
		
		
		
		/**
		 * Verifying created first name
		 */
	createEmployeeResponse.then().assertThat().body("Employee[0].emp_firstname", equalTo("Alexsandra"));

		/**
		 * Verifying server using then().header()
		 */
		createEmployeeResponse.then().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");

		/**
		 * Verifying Content-Type using assertThat().header()
		 */
		createEmployeeResponse.then().assertThat().header("Content-Type", "application/json");
		
	}
	

	
//Get created Employee
	
@Test
public void bGETcreatedEmployee() {
	System.out.println(".......................... ..........  b GET Created Employee  ................................");
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
	System.out.println(".......................... ..........  c Get All Employees  ................................");
	RequestSpecification getAllEmployeesRequest	=given().header("Content-Type","application/json").header("Authorization",token);
	
	Response getAllEmployeesResponse=getAllEmployeesRequest.when().get("/getAllEmployees.php");
	/**Printing all employees */
//getAllEmployeesResponse.prettyPrint();// wh we commend out because we do not want print them
	
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
	 * if stattement inside for loop to find stored employee ID and break the loop when found 
	 * */
	
	if(allEmployeeIDs.contentEquals(employeeID));
	//System.out.println("Employee ID :"+employeeID +" is present in body");
	String employeeFirstName=js.getString("Employees["+i+"].emp_firstname");
	//System.out.println(employeeFirstName);
	
	break;
	}
}
@Test	
public void dPUTupdateCreatedEmployee() {
	System.out.println(".......................... ..........  d PUT Update Created Employee ................................");
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
	
	
//	String response =updateCreatedEmployeeResponse.prettyPrint();
	
	updateCreatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
	String empID=updateCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");

	Assert.assertTrue(empID.contentEquals(employeeID));
	
}
@Test
public void eGETUpdatedEmployee() {
	System.out.println(".......................... ..........  e GET Updated Employee   ................................");
	/**
	 * preparing request to get updated employee
	 */
	RequestSpecification getUpdatedEmpRequest = given().header("Content-Type", "application/json").header("Authorization", token).queryParam("employee_id", employeeID);
	
	Response getUpdatedEmpResponse = getUpdatedEmpRequest.when().get("/getOneEmployee.php");

	//getUpdatedEmpResponse.prettyPrint();

	getUpdatedEmpResponse.then().assertThat().statusCode(200);
	
	getUpdatedEmpResponse.then().assertThat().body("employee[0].emp_firstname",equalTo("Alexsandra"));
//	getUpdatedEmpResponse.then().assertThat().body("employee[0].employee",equalTo("20246A")); //buna bak hata veriyor
}


@Test
public void fPATCHpartiallyUpdateEmployee() {
	System.out.println(".......................... .......... fPATCH Partially Update Employee ................................");
	// 1- given - prepare our request
	RequestSpecification  partiallyUpdateEmployeeRequest=given().header("Content-Type", "application/json").header("Authorization",token).queryParam("employee_id", employeeID).body("{\r\n" + 
			"			  \"employee_id\":\""+employeeID+"\",\n" + 
			"			  \"emp_job_title\": \"Developer\"\r\n" + 
			"			}");
	
	// 2- when - we are making the call to the endpoint 
	Response partiallyUpdateEmployeeResponse=partiallyUpdateEmployeeRequest.when().log().all().patch("/updatePartialEmplyeesDetails.php");
	partiallyUpdateEmployeeResponse.then().assertThat().statusCode(201);
	partiallyUpdateEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
	
}

//// GET Partially Updated Employee
//@Test
//public void jGETpartiallyUpdatedEmployee() {
//	System.out.println(".......................... ..........  j GET Partially Updated Employeee ................................");
//	// 1- given - prepare our request
//	RequestSpecification  getPartiallyUpdatedEmployeeRequest=given().header("Content-Type", "application/json").header("Authorization",token).param("employee_id", employeeID);
//	
//	// 2- when - we are making the call to the endpoint 
//	Response getPartiallyUpdatedEmployeeResponse = getPartiallyUpdatedEmployeeRequest.when().log().all().get("/getOneEmployee.php");
//	
//String response=getPartiallyUpdatedEmployeeResponse.prettyPrint();
//	
//	
////3  Then validating
//getPartiallyUpdatedEmployeeResponse.then().assertThat().body("Message", equalTo("Entry updated"));
//
//}


// DELETE Created Employee
@Test
public void kDELETEcreatedEmployee() {
	System.out.println(".......................... ..........  k DELETE Created Employee  ................................");
	// 1- given - prepare our request
	RequestSpecification  deleteCreatedEmployeeRequest=given().header("Content-Type", "application/json").header("Authorization",token).params("employee_id",employeeID);
	
	
	// 2- when - we are making the call to the endpoint 
	Response deleteCreatedEmployeeResponse=deleteCreatedEmployeeRequest.when().log().all().delete("/deleteEmployee.php");
	deleteCreatedEmployeeResponse.prettyPrint();
	
	//3  Then validating
	deleteCreatedEmployeeResponse.then().assertThat().body("message", equalTo("Entry deleted"));
	
}}




