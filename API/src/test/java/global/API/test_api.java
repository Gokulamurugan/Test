package global.API;


import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class test_api extends commonactions {
	
	@Test(priority = 1)
	public void test_queries_API_for_all_launches() throws InterruptedException {
		try {
		String requestBody =  readtxt.Radfile("RequestPayload").replace("^^", readtxt.Radfile("RequestPayload_limit_val1"));
		commonactions.api_Assert_verification(requestBody);}catch(Exception e) {e.printStackTrace();}

	}
	@Test(priority = 2)
	public void test_update_limit_parameter_and_returns_number_of_launches() throws InterruptedException {  
		try {
		String requestBody =  readtxt.Radfile("RequestPayload").replace("^^",readtxt.Radfile("RequestPayload_limit_val2") );
		commonactions.api_Assert_verification(requestBody);}catch(Exception e) {e.printStackTrace();}

	}
	@Test(priority = 3)
	public void test_update_offset_parameter_and_returns_number_of_launches() throws InterruptedException {  
		try {
		String requestBody =  readtxt.Radfile("RequestPayload_limit_Offset").replace("^^",readtxt.Radfile("RequestPayload_LF_limit"));
		requestBody = requestBody.replace("??",readtxt.Radfile("RequestPayload_LF_offset"));
		commonactions.api_Assert_verification(requestBody);}catch(Exception e) {e.printStackTrace();}

	}
	

	
	
	
}