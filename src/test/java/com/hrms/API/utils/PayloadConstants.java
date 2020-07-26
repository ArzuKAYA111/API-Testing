package com.hrms.API.utils;

import org.json.JSONObject;

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
	 * Creating payload using JSONObject and return it as a String 
	 * @return
	 */
	public static String  createEmployeePayload() {
		
		JSONObject obj=new JSONObject();
		
		obj.put("emp_firstname", "Alexsandra");  // string key object method we choosed
		obj.put("emp_lastname", "White");
		obj.put("emp_middle_name", "Alex");
		obj.put("emp_gender", "F");
		obj.put("emp_birthday", "2001-07-03");
		obj.put("emp_status", "Freelance");
		obj.put("emp_job_title", "API Tester");
		
		return obj.toString();// it wiil return to String 
		
		
		
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
