package com.hrms.API.steps.practice;

public class HardcodedConstants {

public String updateCreatedEmployee() {
	

	String updatedBody="{\r\n" + 
			"  \"employee_id\": \""+HardcodedExamples_1.employeeID+"\",\r\n" + 
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
	
}
