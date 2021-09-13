package PageFactory;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoShop_HomePage extends commonactions {
	static String Home_ele= "//a[@title='Home']";
	static String Cookies_ele= "//a[text()='Accept all']";
	static String Shop_ele= "//a[@title='Shop']";
	static String Shop_Webtable= "//ul[contains(@class,'products columns')]/li";
	static String wishList_ele= "(//i[@class='lar la-heart'])[1]";
	static String wishList_Webtable= "//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr";
	static String wishList_table= "//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody";
	
	
	static String [] Select_items = new String[4];
	static String [] Item_Value = new String[4];
	
	
	
	
  public demoShop_HomePage(WebDriver driver) {
		super(driver);		
	}

	public static void HomePage_Login() throws Throwable {
	try {
		String header_title = Launch_Browser(Home_ele);
		assertEquals("TESTSCRIPTDEMO – Automation Practice", header_title);
		Element_clk(Home_ele);
		Wait(Cookies_ele);
		Element_clk(Cookies_ele);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	 public static void product_add_my_wish_list() throws Throwable {
		try {
			Wait(Shop_ele);
			Element_clk(Shop_ele);
			Thread.sleep(500);
			Select_items  = Webtable_Shop(Shop_Webtable).split("@");
			
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
	 
	 public static void view_my_wish_list() throws Throwable {
			try {
				Wait(wishList_ele);
				Element_clk(wishList_ele);
				Thread.sleep(500);
				Element_Isdisplayed(wishList_table);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
	 public static void four_Selected_Items_in_mywish_list() throws Throwable {
			try {
				
				Thread.sleep(500);
				Element_Isdisplayed(wishList_table);
				Wishlist_Item_verification(wishList_Webtable,Select_items);
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
	
	 public static void search_lowest_prise_product() throws Throwable {
			try {
				
				Thread.sleep(500);
				 String outval = Wishlist_Item_lowest_price(wishList_Webtable);
				 Item_Value = outval.split("£");
				System.out.println(Item_Value[4]);
				 
//		
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
	
	 public static void lowest_prise_Item_Add_cart() throws Throwable {
			try {
				
				Thread.sleep(500);
				Wishlist_Item_addto_cart(wishList_Webtable,Item_Value[4]);
				
				
				} catch (Exception e) {
				e.printStackTrace();
				}
			}
	
	
	
	
	
	

}
