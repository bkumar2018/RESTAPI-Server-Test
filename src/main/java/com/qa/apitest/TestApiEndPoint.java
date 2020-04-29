package com.qa.apitest;

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
}
