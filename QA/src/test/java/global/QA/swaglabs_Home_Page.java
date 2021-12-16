package global.QA;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class swaglabs_Home_Page extends commonactions {

	static String UserName_ele= readtxt.Radfile("UserName_path");
	static String Password_ele=readtxt.Radfile("Password_path");
	static String Loginbutton_ele = readtxt.Radfile("Loginbutton_path");
	static String Productdp_ele = readtxt.Radfile("Productdp_path");
	static String ItemPrice_ele = readtxt.Radfile("ItemPrice_path");
	static String Addcart_ele = readtxt.Radfile("Addcart_path");
	static String Basket_ele = readtxt.Radfile("Basket_path");
	static String Checkout_ele = readtxt.Radfile("Checkout_path");
	static String Firstname_ele = readtxt.Radfile("Firstname_path");
	static String Lastname_ele = readtxt.Radfile("Lastname_path");
	static String Zipcode_ele = readtxt.Radfile("Zipcode_path");
	static String Continue_ele = readtxt.Radfile("Continue_path");
	static String Finish_ele = readtxt.Radfile("Finish_path");
	static String PriceSort_ele  = readtxt.Radfile("PriceSort_path");
	static String Ckout_ele  = readtxt.Radfile("Ckout_path");



	public swaglabs_Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void HomePage_Login() throws Throwable {
		try {
			String header_title = Launch_Browser(UserName_ele);
			assertEquals("Swag Labs", header_title);
			Element_sendkeys(UserName_ele,readtxt.Radfile("Username"));
			Element_sendkeys(Password_ele,encrypy_decrypt.decrypt(readtxt.Radfile("Password"),readtxt.Radfile("secretKey")));
			Element_clk(Loginbutton_ele);
			Wait(Productdp_ele);
			assertTrue(Element_Isdisplayed(Productdp_ele));//   

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Sort_product_price() throws Throwable {
		try {

			Element_Dropdown(Productdp_ele,readtxt.Radfile("ProSort"));
			String ExpVal =  Element_getText(PriceSort_ele).toUpperCase();
			assertEquals(ExpVal,readtxt.Radfile("ProSort").toUpperCase());
			System.out.println("The Product sorted by high to low Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Add_cheapest_2nd_costliest_products_to_basket() throws Throwable {
		try {

			List<WebElement> List_ele = Element_list(ItemPrice_ele);
			float array[] = new float [List_ele.size()];
			for(int i=0;i<List_ele.size();i++) {
				String val = List_ele.get(i).getText().trim().replace("$","");
//				System.out.println(val);
				array[i]= Float.parseFloat(val);

			}
			int minindex = 0;
			float minValue = array[0];
			for(int i=0;i<array.length;i++){
				if(array[i] < minValue){
					minValue = array[i];
//					System.out.println(minValue);
					minindex = i+1;
				}
			}
			// Select the Cheapest product
			Element_clk_index(Addcart_ele,minindex);
			System.out.println("The cheapest product added to cart");

			int maxindex = 0;
			float Second_maxValue = array[0];
			for(int i=0;i<2;i++){
				if(array[i] < Second_maxValue){
					Second_maxValue = array[i];
//					System.out.println(Second_maxValue);
					maxindex = i+1;

				}
			}

			// Select the Second max price product
			Element_clk_index(Addcart_ele,maxindex);

			System.out.println("The second costliest product added to cart");


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void open_basket() throws Throwable {
		try {

			Element_clk(Basket_ele);
			Wait(Checkout_ele);
			assertTrue(Element_Isdisplayed(Checkout_ele));
			//Verify the data 
			System.out.println("CHECKOUT: YOUR INFORMATION opened successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void checkout_product() throws Throwable {
		try {

			Element_clk(Checkout_ele);
			Wait(Firstname_ele);
			assertTrue(Element_Isdisplayed(Firstname_ele));

			//Verify the checkout page and data 

			System.out.println("CHECKOUT: OVERVIEW is loaded");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Enter_details_and_Finish_purchase() throws Throwable {
		try {

			Element_sendkeys(Firstname_ele,readtxt.Radfile("Firstname"));
			Element_sendkeys(Lastname_ele,readtxt.Radfile("Lastname"));
			Element_sendkeys(Zipcode_ele,readtxt.Radfile("Zipcode"));

			Element_clk(Continue_ele);
			Wait(Finish_ele);
			assertTrue(Element_Isdisplayed(Finish_ele));
			System.out.println("User details entered in checkout page successfully");
	
			Element_clk(Finish_ele);
			String ExpVal =  Element_getText(Ckout_ele).toUpperCase();
			assertEquals(ExpVal,readtxt.Radfile("Ckoutcomp").toUpperCase());
			System.out.println("CHECKOUT: COMPLETE!");
		

			//Verify the checkout page and data 


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
