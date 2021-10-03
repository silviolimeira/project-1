package com.sl.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sl.batch.model.*;

public class Communicator {

	String data;
	OperationMode operationMode;
	public TemperatureSensor[] temperatureSensors;

	public Communicator() {
		// configure Operation.GET with standard
		this.operationMode = OperationMode.GET;
	}

	public Communicator(OperationMode operationMode) {
		this.operationMode = operationMode;
	}

	public void execute() throws IOException {
		if (this.operationMode == OperationMode.GET) {
			get();
		} else if (this.operationMode == OperationMode.POST) {
			post();
		}
	}

	private void get() throws IOException {

		URL url = new URL("https://monitortracker.rj.r.appspot.com/getTemperatureSensors");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		String result = "";
		// System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			// System.out.println(output);
			result += output;
		}

		ObjectMapper mapper = new ObjectMapper();

		try {

			// 1. convert JSON array to Array objects
			// TemperatureSensor[] pp1 = mapper.readValue(result,
			// TemperatureSensor[].class);
			this.temperatureSensors = mapper.readValue(result, TemperatureSensor[].class);
			// String json = mapper.writeValueAsString(temperatureSensors);
			// System.out.println(json);
			/*
			 * 
			 * //System.out.println("JSON array to Array objects..."); for (User user : pp1)
			 * { System.out.println(user);
			 * 
			 * // Convert ObjectMapper to json string String json =
			 * mapper.writeValueAsString(user);
			 * //System.out.println(">>>>>>>>>> ResultingJSONstring = " + json);
			 * 
			 * }
			 */
			// 2. convert JSON array to List of objects
			/*
			 * List<User> ppl2 = Arrays.asList(mapper.readValue(result, User[].class));
			 * 
			 * System.out.println("\nJSON array to List of objects");
			 * ppl2.stream().forEach(x -> System.out.println(x));
			 * 
			 * // 3. alternative List<User> pp3 = mapper.readValue(result, new
			 * TypeReference<List<User>>() {});
			 * 
			 * System.out.println("\nAlternative..."); pp3.stream().forEach(x ->
			 * System.out.println(x));
			 */

		} catch (IOException e) {
			e.printStackTrace();
		}

		conn.disconnect();

	}

	private void post() throws IOException {

		try {

			URL url = new URL("https://monitortracker.rj.r.appspot.com/saveTemperature");
			//URL url = new URL("http://localhost:8080/addTemperature");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
			conn.setRequestProperty("Connection", "keep-alive");

			// String input = "{\"id\":2,\"name\":\"iPad 4\",\"password\":\"ipad4\"}";
			ObjectMapper mapper = new ObjectMapper();
			//TemperatureSensor temperatureSensor = new TemperatureSensor(1L, "temperature_01", 26.5f, new Date());
			TemperatureSensor temperatureSensor = new TemperatureSensor(1L, "temperature_01", 26.5f, null);
			String json = mapper.writeValueAsString(temperatureSensor);
			// System.out.println(json)

			OutputStream os = conn.getOutputStream();
			os.write(json.getBytes());
			os.flush();

			System.out.println("Response Code: " + conn.getResponseCode());

//	        if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
//	            throw new RuntimeException("Failed : HTTP error code : "
//	                + conn.getResponseCode());
//	        }

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
