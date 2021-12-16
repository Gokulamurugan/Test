package global.API;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class commonactions extends readtxt{
	
  public static Response respons(String Reqpayload) {
		try{RestAssured.baseURI = readtxt.Radfile("BaseUri");
		
		String requestBody =  Reqpayload;
		// Given
		Response firstresp = given()
		.contentType("application/json")
		.body(requestBody)
		// When
		.when()
		.post("/graphql")
		// Then
		.then()
		.extract().response();
		return firstresp;}
		catch(Exception e) {e.printStackTrace();return null;}
	}
  public static int Verify_status_code(Response parm) {
		try{int Status_code = parm.statusCode();
		return Status_code;}
		catch(Exception e) {e.printStackTrace();return (Integer) null;}
	}
  
  public static String Verify_jsonPath(Response parm,String Jpath) {
	  String J_response = parm.jsonPath().getString(Jpath);
		return J_response;
	}
  
  public static List<String> Verify_getlist(Response parm,String Jpath) {
	  List<String> NumLaunches = parm.jsonPath().getList(Jpath);
		return NumLaunches;
	}
	
	public static void api_Assert_verification(String Reqpayload) throws InterruptedException {  
       try {
		//Verification of 'Assert status code is 200'
		int Status_code= Verify_status_code( commonactions.respons(Reqpayload));
		System.out.println("Response code is " +Status_code);
		int statcode = Integer.parseInt(readtxt.Radfile("Statuscode"));
		Assert.assertEquals(statcode, Status_code);}catch(Exception e) {e.printStackTrace();}
       
		try {
		//Verification of 'Assert mission name object is not empty'
		String missionname = Verify_jsonPath(commonactions.respons(Reqpayload),readtxt.Radfile("missionName_jpath"));   
		System.out.println("Response is " +missionname);
		Assert.assertEquals(missionname.contains(readtxt.Radfile("missionName_val")),true);}catch(Exception e) {e.printStackTrace();}
		
		try {
		//Verification of 'Assert that the number of launches is greater than 0'
		List<String> NumLaunches = Verify_getlist(commonactions.respons(Reqpayload),readtxt.Radfile("Launch_jpath"));
		System.out.println("Number of Launches is " +NumLaunches.size());
		Assert.assertTrue(NumLaunches.size() > 0);}catch(Exception e) {e.printStackTrace();}
		
		try {
		//Verification of 'Assert that that the number of ships is greater than 0
		List<String> NumShips = Verify_getlist(commonactions.respons(Reqpayload),readtxt.Radfile("Ships_jpath"));
		System.out.println("Number of Ships is " +NumShips.size());
		Assert.assertTrue(NumShips.size() > 0);}catch(Exception e) {e.printStackTrace();}
		
		try {
		//Verification of Assert the first stage & second stage are not null	
		List<String> rocket_1stage = Verify_getlist(commonactions.respons(Reqpayload),readtxt.Radfile("rocket_1_jpath"));
		Thread.sleep(3000);
		System.out.println("Number of 1st stages " +rocket_1stage.size());		
		Assert.assertNotNull(rocket_1stage);}catch(Exception e) {e.printStackTrace();}
		
		try {
		List<String> rocket_2stage = Verify_getlist(commonactions.respons(Reqpayload),readtxt.Radfile("rocket_2_jpath"));
		Thread.sleep(3000);
		System.out.println("Number of 2nd stages  " +rocket_2stage.size());		
		Assert.assertNotNull(rocket_2stage);}catch(Exception e) {e.printStackTrace();}
		
	}
  
  

  
	
}
