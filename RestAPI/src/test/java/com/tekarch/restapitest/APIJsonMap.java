package com.tekarch.restapitest;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class APIJsonMap {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String json="{\"name\":\"Anu\",\"age\":\"47\"}";
		//String json = "{\"name\":\"mkyong\", \"age\":\"37\"}";
		try {
			Map<String, String> map = mapper.readValue(json, Map.class);
			System.out.println(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
