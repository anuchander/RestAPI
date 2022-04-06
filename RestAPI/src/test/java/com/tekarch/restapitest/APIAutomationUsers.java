package com.tekarch.restapitest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
/* equalTo
 * startsWith
 * hasItems
 * 
 * Number: 
 * equalTo
 * greatThan
 * greaterThanorEqualTo
 * lessThan
 * lessThanorEqualTo 
 *
 * String
 * equalTo
 * statsWith
 * endWith
 * equalToIgnoreCase
 * equalToIgnoreWhitespace
 * ContainsString
 * 
 * Collections:
 * hasItems
 * hasItem
 * hasKey
 * hadValue
 * empty
 * 
 */

/*  Read the Json
 *  complete response with the json data
 *  using the Hamcrest Matcher
 */


public class APIAutomationUsers {

	String sHostURL = "https://jsonplaceholder.typicode.com";
	String sEDPLogin = "/users";
	String sURI="";
	
	
	@Test
	public void validateUser() throws IOException{
		String filePath = System.getProperty("user.dir")+File.separator+"TestData"+File.separator+"JsonInput.json";
		String fileReadytoRead = readFileReturnString(filePath);
		String ExpectedName = JsonPath.read(fileReadytoRead, "$[0].name");
		
		sURI=sHostURL+sEDPLogin;
		RestAssured.baseURI=sURI;
		Response response = RestAssured.given().when().get();
		String ActualName = response.jsonPath().get("name[0]");
		System.out.println("ExpectedName is:"+ExpectedName);
		System.out.println("ActualName is:"+ActualName);
		if (response.statusCode()==200) {
			RestAssured.given().when().get().then().body("name[0]", startsWith(ExpectedName));
		}
		
		
		
	}
		private static String readFileReturnString(String filePath) throws IOException {
			byte[] encoded = Files.readAllBytes(Paths.get(filePath));
		return new String (encoded, StandardCharsets.UTF_8);
		}
	
	
	
	
}

