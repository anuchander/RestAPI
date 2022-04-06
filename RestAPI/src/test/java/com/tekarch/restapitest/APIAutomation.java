package com.tekarch.restapitest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;

public class APIAutomation {

	String sHostURL = "https://us-central1-qa01-tekarch-accmanager.cloudfunctions.net";
	String sLogin = "/login";
	String sURI = "";
	String sEPData = "/getData";
	String sToken;

	
	@Test
	public void validateLogin() {
		sURI = sHostURL+sLogin;
		RestAssured.baseURI=sURI;
		Response response = RestAssured.given().body("{\r\n"
		  		+ "    \"username\": \"mithun@ta.com\",\r\n"
		  		+ "    \"password\": \"mithun\"\r\n"
		  		+ "}").when().contentType("application/json").post();
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		sToken= response.jsonPath().get("token[0]");
		System.out.println(sToken);
		
		sURI = sHostURL+sEPData;
		RestAssured.baseURI=sURI;
		HashMap<String, String> headData = new HashMap<String, String>();
		headData.put("token", sToken);
		
		response = RestAssured.given().headers(headData).when().contentType("application/json").get();
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		//List<String> listId = response.jsonPath().getList("id");
		//System.out.println(listId.size());
		//System.out.println(response.prettyPrint());
				
	}
	
}
