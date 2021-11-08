package StepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.commonactions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef  {
	


@Given("^I add four different products to my wish list$")
public void i_add_four_different_products_to_my_wish_list() throws Throwable {
	PageFactory.demoShop_HomePage.HomePage_Login();
	PageFactory.demoShop_HomePage.product_add_my_wish_list();
	System.out.println("The Products added successfully in my wish list section");
	
    //throw new PendingException();
}

@When("^I view my wishlist table$")
public void i_view_my_wishlist_table() throws Throwable {
	PageFactory.demoShop_HomePage.view_my_wish_list();
	System.out.println("The View my wish list displayed successfully");
}

@Then("^I find total four selected items in my Wishlist$")
public void i_find_total_four_selected_items_in_my_Wishlist() throws Throwable {
	PageFactory.demoShop_HomePage.four_Selected_Items_in_mywish_list();
	System.out.println("The total fourselected items displayed successfully in my Wishlist");
}

@When("^I search for lowest price product$")
public void i_search_for_lowest_price_product() throws Throwable {
	PageFactory.demoShop_HomePage.search_lowest_prise_product();
	System.out.println("The lowest price product searched successfully in my Wishlist");
	
}

@When("^I am able to add the lowest price item to my cart$")
public void i_am_able_to_add_the_lowest_price_item_to_my_cart() throws Throwable {
	PageFactory.demoShop_HomePage.lowest_prise_Item_Add_cart();
}

@Then("^I am able to verify the item in my cart$")
public void i_am_able_to_verify_the_item_in_my_cart() throws Throwable {
    
	commonactions.Browser_Close();
	
}



}
