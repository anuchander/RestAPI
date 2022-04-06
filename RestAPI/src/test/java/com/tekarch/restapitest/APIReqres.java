package com.tekarch.restapitest;

import java.io.InputStream;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APIReqres {

	String sHostURL = "https://reqres.in";
	String sERPLogin = "/api/users/2";
	String sAPIUser = "/api/unknown";
	String sAPIUser2 ="/api/unknown/2";
	String sAPIUser23 ="/api/unknown/23";
	String sAPIUsers ="/api/users";
	
	
	
	String sURI="";
	
	@Test
	public void validateReqres() {
		sURI=sHostURL+sERPLogin;
		RestAssured.baseURI=sURI;
		Response response = RestAssured.given().when().get();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("****************All Users***************");
		sURI=sHostURL+sAPIUser;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().when().get();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("************User2 data**************");
		sURI=sHostURL+sAPIUser2;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().when().get();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("************User23 data**************");
		sURI=sHostURL+sAPIUser23;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().when().get();
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("******************Post User*************");
		sURI=sHostURL+sAPIUsers;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().body("{\"name\":\"morpheusabc\", \"job\":\"leader\"}")
				.when().contentType("application/json").post();;
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("******************Update User2 with Put**********");
		sURI=sHostURL+sERPLogin;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().body("{\"name\":\"morpheusabc\", \"job\":\"zion resident\"}")
				.when().contentType("application/json").put();;
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		System.out.println("******************Delete User2 with Delete**********");
		sURI=sHostURL;
		RestAssured.baseURI=sURI;
		response=RestAssured.given().header("Content-type", "application/json")
				.when().delete("/api/users/2");
		System.out.println(response.getStatusCode());
		response.prettyPrint();
		
		
		
	}
}
