package com.tekarch.restapitest;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APICountries {
	
	String sHostURL = "https://restcountries.com/v3.1";
	String sERPLogin = "/all";
	String sURI="";
	
	@Test
	public void validateCountries() {
		sURI=sHostURL+sERPLogin;
		RestAssured.baseURI=sURI;
		Response response = RestAssured.given().when().get();
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		List<String>  countryNames = response.jsonPath().get("name.common");
		System.out.println(countryNames.size());
		System.out.println(countryNames);
		for(int i =0; i<countryNames.size(); i++) {
			System.out.println("countryNames(i)");
		}
		
		
		
	
	}
}
