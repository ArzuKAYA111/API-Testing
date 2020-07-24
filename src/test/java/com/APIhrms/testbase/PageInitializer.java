package com.APIhrms.testbase;

import com.APIhrms.pages.AddEmployeePageElements;
import com.APIhrms.pages.DashBoardPageElements;
import com.APIhrms.pages.LoginPageElements;
import com.APIhrms.pages.PersonalDetailsPageElements;
import com.APIhrms.pages.contactDetailsPageElements;
import com.APIhrms.pages.viewEmployeeListPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements login;
	public static DashBoardPageElements dashboard;
	public static AddEmployeePageElements addEmp;
	public static PersonalDetailsPageElements pdetails;
    public static contactDetailsPageElements contDetail;
    public static viewEmployeeListPageElements viewEmp;
	public static void initialize() {
	 login=new LoginPageElements();
	 dashboard=new DashBoardPageElements();     //we are calling the constructor of page calsses
	 addEmp= new AddEmployeePageElements();
	 pdetails= new PersonalDetailsPageElements();
	 contDetail= new contactDetailsPageElements();
	 viewEmp=new viewEmployeeListPageElements();
	 
	 
	}
	
	
	
	
	
	
	
	
}
