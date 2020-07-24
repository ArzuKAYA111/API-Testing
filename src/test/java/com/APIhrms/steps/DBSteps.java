package com.APIhrms.steps;

import java.util.List;
import java.util.Map;

import com.APIhrms.Utils.DBUtils;
import com.APIhrms.Utils.GlobalVariables;

import io.cucumber.java.en.Then;

public class DBSteps {
	
	public static List<Map<String,String>> dbData;

	@Then("get first name from db")
	public void get_first_name_from_db() {
	String sqlQuery="select emp_firstname from hs_hr_employees where employee_id="+ GlobalVariables.empID; 
	
			dbData=DBUtils.storeDataFromDB(sqlQuery);	
	
		
	}
	@Then("get last name from db")
	public void get_last_name_from_db() {
	   
	String	
		sqlQuery="select emp_lastname from hs_hr_employees where employee_id= "+ GlobalVariables.empID;
	dbData=DBUtils.storeDataFromDB(sqlQuery);
		
	}
	
}
