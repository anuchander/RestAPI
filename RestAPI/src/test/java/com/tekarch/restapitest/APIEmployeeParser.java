package com.tekarch.restapitest;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tekarch.pojopackage.Employee;
import com.tekarch.pojopackage.phoneNumbers;
import com.tekarch.pojopackage.Address;
public class APIEmployeeParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		try {
			Employee employee = mapper.readValue(new File("example.json"), Employee.class);
			System.out.println("firstname:" + employee.getFirstName());
			System.out.println("lastname:" + employee.getLastName());
			System.out.println("age:" + employee.getAge());
			Address address = employee.getAddress();
			System.out.println("streetname:"+ address.getStreetAddress());
			System.out.println("city: "+ address.getCity());
			System.out.println("state: "+ address.getState());
			System.out.println("zip:"+ address.getPostalCode());
			phoneNumbers phoneNumber = employee.getPhoneNumber();
			System.out.println("First phone type:"+ phoneNumber.getType());
			System.out.println("First phone number:"+ phoneNumber.getNumber());
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
