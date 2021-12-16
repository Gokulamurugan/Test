package StepDef;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.QA.encrypy_decrypt;

public class StepDef {
	
@Before	
public void tes(){
String originalString ="secret_sauce";
String secretKey = "jkeaj84#@%yj";
String encryptedString = encrypy_decrypt.encrypt(originalString, secretKey) ;
String decryptedString = encrypy_decrypt.decrypt(encryptedString, secretKey) ;

System.out.println(encryptedString);
System.out.println(decryptedString);
}
	

@Given("^Login to https://www\\.saucedemo\\.com/ using the \"([^\"]*)\" account$")
public void login_to_https_www_saucedemo_com_using_the_account(String arg1) throws Throwable {
	global.QA.swaglabs_Home_Page.HomePage_Login();
    
}

@When("^Sort the products by Price \\(high to low\\)$")
public void sort_the_products_by_Price_high_to_low() throws Throwable {
	global.QA.swaglabs_Home_Page.Sort_product_price();
    
}

@When("^Add the cheapest & the (\\d+)nd costliest products to your basket$")
public void add_the_cheapest_the_nd_costliest_products_to_your_basket(int arg1) throws Throwable {
	global.QA.swaglabs_Home_Page.Add_cheapest_2nd_costliest_products_to_basket();
    
}

@When("^Open the basket$")
public void open_the_basket() throws Throwable {
    global.QA.swaglabs_Home_Page.open_basket();
    
}

@When("^Checkout$")
public void checkout() throws Throwable {
    global.QA.swaglabs_Home_Page.checkout_product();
    
}

@Then("^Enter details and Finish the purchase$")
public void enter_details_and_Finish_the_purchase() throws Throwable {
    global.QA.swaglabs_Home_Page.Enter_details_and_Finish_purchase();
	global.QA.commonactions.Browser_Close();
    
}





}
