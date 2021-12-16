package global.API;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class readtxt {
	
	
public static String Radfile(String Expval)  {  
	    try {
	      String[] val1 = new String[1];
	      File myObj = new File("graphql_api.txt");
	      Scanner myReader = new Scanner(myObj);  
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        if (data.contains(Expval)) {
	        	 val1 = data.split("=");
	        	  String getval =val1[1];
	        	return getval;
	        }
	       
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return null ;
	  }  
	} 

