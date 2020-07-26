package com.hrms.API.utils;

import com.hrms.API.steps.practice.HardcodedExamples;

public class PayloadConstants {


	
	/**
	 * Create employee body
	 * @return
	 */
	public static String createEmployeeBody() {

		String createEmployeeBody="{\r\n" + 
				"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
				" \"emp_lastname\": \"White\",\r\n" + 
				"  \"emp_middle_name\": \"Alex\",\r\n" + 
				" \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
				" \"emp_status\": \"Freelance\",\r\n" + 
				"  \"emp_job_title\": \"API Tester\"\r\n" + 
				"  \r\n" + 
				"}";
		
		return createEmployeeBody;
	}
	
	
	/**
	 * Created method to return payload - to reduce messy code
	 * @return
	 */
	public static String updateCreatedEmpBody() {		
		String updateBody = "{\r\n" + 
				"  \"employee_id\": \"" + HardcodedExamples.employeeID + "\",\r\n" + 
				"  \"emp_firstname\": \"Alexsandra\",\r\n" + 
				"  \"emp_lastname\": \"string\",\r\n" + 
				"  \"emp_middle_name\": \"Alex\",\r\n" + 
				"  \"emp_gender\": \"F\",\r\n" + 
				"  \"emp_birthday\": \"2001-07-03\",\r\n" + 
				"  \"emp_status\": \"Super Contractor\",\r\n" + 
				"  \"emp_job_title\": \"Cloud Architect\"\r\n" + 
				"}";
	
				return updateBody;
		}
		
}
