package PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonactions  {
	 static WebDriver driver;
	public commonactions(WebDriver driver) {
		this.driver= driver;

		}
	
	public static void Wait(String xPath) {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));}catch(Exception e) {e.printStackTrace();}

	}
	public static String Launch_Browser(String xPath) throws InterruptedException {
		String header_title = null;
		try{
			String file_path = readtxt.Radfile("Chromedriverpath");
			Thread.sleep(1000);
			System.setProperty("webdriver.chrome.driver", file_path); 
			driver = new ChromeDriver();
			Thread.sleep(1000);
			driver.get(readtxt.Radfile("URL"));
			Wait(xPath);
			header_title = driver.getTitle();
			driver.manage().window().maximize();
			return header_title;}catch(Exception e) {e.printStackTrace();return header_title; }
		
	}
	
	public static void Element_clk(String xPath) throws InterruptedException {
		try{Wait(xPath);
		driver.findElement(By.xpath(xPath)).click();}catch(Exception e) {e.printStackTrace();}	
	}
	
	public static void Element_Isdisplayed(String xPath) throws InterruptedException {
		try{Wait(xPath);
		driver.findElement(By.xpath(xPath)).isDisplayed();}catch(Exception e) {e.printStackTrace();}	
	}
	
	public static void Browser_Close() throws InterruptedException {
		try{driver.close();}catch(Exception e) {e.printStackTrace();}
		
	}
	public static String Webtable_Shop(String xpath) throws InterruptedException {
		int cnt = 0;
		String Product_items = "";
		List number_items = driver.findElements(By.xpath(xpath));
      
        for (int i =1;i<number_items.size();i++)
        {    
        	String expect_val = driver.findElement(By.xpath("//ul[contains(@class,'products columns')]/li["+i+"]/a[2]")).getText();
        	if(expect_val.contentEquals("Add to cart")) {
        		driver.findElement(By.xpath("//ul[contains(@class,'products columns')]/li["+i+"]/div/div[2]//a//span")).click();
        		Thread.sleep(1000);
        		String Product_item = driver.findElement(By.xpath("//ul[contains(@class,'products columns')]/li["+i+"]//h2")).getText();
        		Product_items = Product_item+"@"+ Product_items;	
        		cnt= cnt+1; 
        		if(cnt == 4) {
        			
        			break;
        		}
        		
        	}
        	
        }
        return Product_items;
	}
	
	public static void Wishlist_Item_verification(String xpath,String[] Select_items) throws InterruptedException {
		
		List Wishlst_item = driver.findElements(By.xpath(xpath));
		
        for (int i =1;i<Wishlst_item.size();i++)
        {    
        	 String expect_val1 = driver.findElement(By.xpath("//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr["+i+"]/td[3]/a")).getText();
 
        	for(int j = 0; j< Select_items.length; j++) {
        		if(expect_val1.contentEquals(Select_items[j])) {
        			System.out.println("The "+expect_val1+" item is added in wishlist");
        	}
	
            }
        	}
        	
        }
	//driver.findElement(By.xpath("//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr["+i+"]/td[6]/a")).click();
		
public static String Wishlist_Item_lowest_price(String xpath) throws InterruptedException {
		
		  List Wishlst_item1 = driver.findElements(By.xpath(xpath));
		   int Cunt =Wishlst_item1.size();
		  String Pro_Item_vals = "";
		 
        for (int i =1;i<Cunt+1;i++)
        {    
        				
        	 String Pro_Item_val = driver.findElement(By.xpath("//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr["+i+"]/td[5]/preceding::bdi[1]")).getText();
  
        	  Pro_Item_vals =  Pro_Item_vals+Pro_Item_val;
        	 
        	 
        	 
        }
		return Pro_Item_vals;
      
         
        }
        	
public static void Wishlist_Item_addto_cart(String xpath, String expval) throws InterruptedException {
	
	  List Wishlst_item1 = driver.findElements(By.xpath(xpath));
	   int Cunt =Wishlst_item1.size();
	 
  for (int i =1;i<Cunt+1;i++) {
	  String Actval= driver.findElement(By.xpath("//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr["+i+"]/td[5]/preceding::bdi[1]")).getText();
	   Actval=  Actval.replace("£", "");
	  if(Actval.contentEquals(expval)) {
		  driver.findElement(By.xpath("//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr["+i+"]/td[6]/a")).click();
		Thread.sleep(1000);
	  }
	  }
  
  	


   
  }
	
	
	
	
	public static int getMinValue(int[] numbers){
		  int minValue = numbers[0];
		  for(int i=1;i<numbers.length;i++){
		    if(numbers[i] < minValue){
		      minValue = numbers[i];
		    }
		  }
		  return minValue;
	}
	
	
	
	//table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody/tr[1]/td[4]
  ////table[contains(@class,'shop_table cart wishlist_table wishlist')]/tbody
	
	
	
	
}
