package com.tekarch.restapitest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIStudentParser {
	public static String getJSONFromFile(String filename) {
		String jsonText = "";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				jsonText += line + "\n";
			}

			bufferedReader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonText;
	}

	public static String getJSONFromURL(String strUrl) {
		String jsonText = "";

		try {
			URL url = new URL(strUrl);
			InputStream is = url.openStream();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				jsonText += line + "\n";
			}

			is.close();
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return jsonText;
	}

	public static void main(String[] args) {
		String strJson = getJSONFromFile("/Users/anu/eclipse-workspace/RestAPI/Students.json");

		/*
		 * 
		 * String strJson = getJSONFromURL(
		 * "https://raw.githubusercontent.com/BoostMyTool/JsonFile/master/example.json"
		 * );
		 * 
		 */

		System.out.println(strJson);

		
		  try { 
			  JSONParser parser = new JSONParser();
			  Object object =parser.parse(strJson); 
			  JSONObject mainJsonObject = (JSONObject) object;
		  
		 /*************** First Name ****************/
		
		  String username = (String) mainJsonObject.get("username");
		  System.out.println("username : " + username);
		  
		 /*************** Last Name ****************/
		
		  String password = (String) mainJsonObject.get("password");
		  System.out.println("password : " + password);
		  
		 /*************** SessionID ****************/
		  
		  JSONArray jsonArraySessionids = (JSONArray) mainJsonObject.get("sessionid");
		  System.out.println("Session Id's : ");
		  
		  //for(int i=0; i<jsonArraySessionids.size(); i++) {
			//  JSONObject jsonSessionid = (JSONObject) jsonArraySessionids.get(i);
			 // Integer sessionid = (Integer) jsonSessionid.get("sessionid");
			 // System.out.println("     Sessionid  : "+ (i+1)  + sessionid);
		 // }
		  
		  JSONArray jsonArrayStudents = (JSONArray) mainJsonObject.get("students");
		  System.out.println("Student's : ");
		  
		  for(int i=0; i<jsonArrayStudents.size(); i++) {
			  JSONObject jsonStudent = (JSONObject) jsonArrayStudents.get(i);
			  String  name = (String) jsonStudent.get("name");
			  System.out.println("Name: "+ name);
			  JSONArray jsonArrayContacts = (JSONArray) jsonStudent.get("contact");
			  for(int j=0; j<jsonArrayContacts.size(); j++) {
				  JSONObject jsonContact = (JSONObject) jsonArrayContacts.get(j);
				  String contact = (String) jsonContact.get("contact");
				  System.out.println("Contact:"+ contact);
			  }
		  }
		  
				  
		  }catch(Exception ex) {
			  ex.printStackTrace(); 
		  	}
														 

	}

}