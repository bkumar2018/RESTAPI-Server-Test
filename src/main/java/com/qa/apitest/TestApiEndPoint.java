package com.qa.apitest;

import org.json.simple.JSONObject;
import org.testng.Assert;

import com.qa.base.RESTAPITestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestApiEndPoint extends RESTAPITestBase{

	public void testApiEndPoint(){
		
		//1. Define the base url		
		//RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI = prop.getProperty("baseUrl");

		//2. define the http request:
		//RequestSpecification httpRequest = RestAssured.given();
		RequestSpecification httpRequest = RestAssured.given();
		
		//3. make a request/execute the request:
		//Response response = httpRequest.request(Method.GET, "/Pune");
		Response response = httpRequest.request(Method.GET, prop.getProperty("apiServiceUrl"));
		Assert.assertEquals(200, response.getStatusCode(),"The status code is not 200!");

		String responseBody = response.getBody().asString();		
		System.out.println("The response Body: "+ responseBody.toString());
		
		
		
	}
	
	public void testApiEndPointUsersDetails(){
		
		RestAssured.baseURI = prop.getProperty("baseUrl");
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, prop.getProperty("userServiceUrl"));
		Assert.assertEquals(200, response.getStatusCode(),"The status code is not 200!");

		String responseBody = response.getBody().asString();		
		System.out.println("The response Body: "+ responseBody.toString());

	}
	
	public void testApiEndPointUsersIdDetails(){
		
		RestAssured.baseURI = prop.getProperty("baseUrl");
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, prop.getProperty("userIdServiceUrl"));
		Assert.assertEquals(200, response.getStatusCode(),"The status code is not 200!");

		String responseBody = response.getBody().asString();		
		System.out.println("The response Body: "+ responseBody.toString());

	}
	
	
	public void testApiEndPointPost() {
		RestAssured.baseURI = prop.getProperty("baseUrl");
		RequestSpecification httprequest = RestAssured.given();
	
		
		/*Body
				 * {
			"id":100,
			"firstname":"Tiru",
			"lastname":"Singh",
			"city":"Pune",
			"pin":12345
			}	
		 */
		
		// We can add Key - Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 100); 
		requestParams.put("firstname", "Birender");
		 
		requestParams.put("lastname", "Singh");
		requestParams.put("city", "Pune");
		requestParams.put("pin",  123456);
		
		// Add a header stating the Request body is a JSON
		httprequest.header("Content-Type", "application/json");
		
		// Add the Json to the body of the request
		httprequest.body(requestParams.toJSONString());
		
		// Post the request and check the response
		Response response = httprequest.post("/api/post");

		Assert.assertEquals(201, response.getStatusCode());
		System.out.println("Reponse Body: "+response.body());
		
		
	}
}
