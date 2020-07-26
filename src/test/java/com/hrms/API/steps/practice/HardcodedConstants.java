package com.hrms.API.steps.practice;

public class HardcodedConstants {

	public String createEmployeeBody() {

		String CreateEmployeeBody="{\r\n" + 
				"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
				"  \"emp_middle_name\": \"Alex\",\r\n" + 
				"  \"emp_lastname\": \"White\",\r\n" + 
				"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
				"  \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_job_title\": \"API Tester\",\r\n" + 
				"  \"emp_status\": \"Freelance\"\r\n" + 
				"}";
		return CreateEmployeeBody;
		
	}
	
public String updateCreatedEmployee() {

	String updatedBody="{\r\n" + 
			"  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\r\n" + 
			"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
			"  \"emp_lastname\": \"string\",\r\n" + 
			"  \"emp_middle_name\": \"Alex\",\r\n" + 
			"  \"emp_gender\": \"F\",\r\n" + 
			"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
			"  \"emp_status\": \"Super Contractor\",\r\n" + 
			"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
			"}";
	return updatedBody;
	
}

public String PartialupdateCreatedEmployee() {
String PartialUpdateBody= "{\r\n" + 
		"		  \"employee_id\": \""+HardcodedExamples.employeeID+"\",\r\n" + 
		"		  \"emp_firstname\": \"string\",\r\n" + 
		"		  \"emp_lastname\": \"string\",\r\n" + 
		"		  \"emp_middle_name\": \"string\",\r\n" + 
		"		  \"emp_gender\": \"Enter M for male or F for female\",\r\n" + 
		"		  \"emp_birthday\": \"2020-07-24\",\r\n" + 
		"		  \"emp_status\": \"string\",\r\n" + 
		"		  \"emp_job_title\": \"string\"\r\n" + 
		"		}";
	return PartialUpdateBody;
}
}