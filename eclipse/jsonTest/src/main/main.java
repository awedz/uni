package main;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WriteJson();

	}
	
	public static void WriteJson() throws Exception
	{
		JSONObject test = new JSONObject();
		test.put("name","aaaa");
		test.put("age",100);
		
		JSONArray somearray = new JSONArray();
		somearray.add("a1");
		somearray.add("a2");
		
		test.put("someArray",somearray);
		try {
			Files.write(Paths.get("jsonTest.json"),test.toJSONString().getBytes());
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
