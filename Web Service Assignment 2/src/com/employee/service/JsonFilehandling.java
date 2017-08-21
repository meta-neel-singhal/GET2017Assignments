package com.employee.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Handles the read and write operations of the file.
 * 
 * @author Neel Singhal
 */
public class JsonFilehandling {

	/**
	 * Handles read operations of the file.
	 * 
	 * @return the list of the JSON objects.
	 */
	public static List<JSONObject> read() {

		JSONParser parser = new JSONParser();
		JSONObject object = null;
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			List<String> employee = new ArrayList<String>();
			employee = Files.readAllLines(Paths.get(Constants.FILE_PATH), Charset.defaultCharset());
			for (String emp : employee) {
				object = (JSONObject) parser.parse(emp);
				list.add((JSONObject) object);
			}
		}
		catch (Exception exception) {
			System.out.println(exception.getMessage());
		}

		return list;
	}

	/**
	 * Handles write operations of the file.
	 * 
	 * @param details to write in the file.
	 */
	public static void write(Object details) {
		JSONObject object = (JSONObject) details;

		try {
			FileWriter file = new FileWriter(Constants.FILE_PATH, true);
			file.write(object.toJSONString());
			file.flush();
		}
		catch (IOException exception) {
			System.out.println(exception.getMessage());
		}

		System.out.print(object);
	}
}