package com.tekarch.restapitest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIAccounts {
	
	String sHostURL="https://qa01-tekarch-accmanager.web.app/";
	String sEDPData="getdata";
	String sURI="";
	
			
	@Test
	public void validateLogin() {
	RestAssured.baseURI=sHostURL;
	Response response = RestAssured.given().body("{\r\n"
		  		+ "    \"username\": \"anuchander@ta.com\",\r\n"
		  		+ "    \"password\": \"anunarayanan@123\"\r\n"
		  		+ "}").when().contentType("application/json").post();
	
	System.out.println(response.statusCode());
	
	sURI=sHostURL+sEDPData;
	RestAssured.baseURI=sURI;
	response=RestAssured.given().when().get();
	System.out.println(response.statusCode());
	response.prettyPrint();
	
		
	}
	//https://qa01-tekarch-accmanager.web.app/

	//	User name :- 
	//	anuchander@ta.com

	//	Password :- 
	//	anunarayanan@123
}
