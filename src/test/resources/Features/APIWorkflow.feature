@workflow
Feature: Syntax HRMS API End to End Workflow
#Description :This feature tests and verifies Syntax HRMS web Services The workflow consist of the following sequential calls

Background: 
Given a JWT is created

  Scenario: Creating an employee
   Given a request is prepared to create an employee
   When a POST call is made to create an employee 
   Then the status code for creating an employee is 201
   And the employee is created and response contains key "Message" and value "Entry Created"
   And the employee ID "Employee[0].employee_id" is stored as a global variable to be used for other calls

