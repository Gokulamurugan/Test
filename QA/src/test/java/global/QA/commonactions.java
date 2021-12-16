package global.QA;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class commonactions  {
	static WebDriver driver;
	public commonactions(WebDriver driver) {
		this.driver= driver;
	}

	public static void Wait(String xPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10000);
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
   
	public static String Element_getText(String xPath) throws InterruptedException {
		try{Wait(xPath);
		String Val =driver.findElement(By.xpath(xPath)).getText().trim(); return Val;}catch(Exception e) {e.printStackTrace(); return null;}	
	}

	public static void Element_sendkeys(String xPath,String input) throws InterruptedException {
		try{Wait(xPath);
		driver.findElement(By.xpath(xPath)).sendKeys(input);}catch(Exception e) {e.printStackTrace();}	
	}

	public static void Element_clk_index(String xPath,int minindex) throws InterruptedException {
		try{
			xPath = xPath.replace("VL^", String.valueOf(minindex)) ;
			Wait(xPath);
			driver.findElement(By.xpath(xPath)).click();}catch(Exception e) {e.printStackTrace();}	
	}

	public static void Element_Dropdown(String xPath,String input) throws InterruptedException {
		try{Wait(xPath);
		Select drplst = new Select(driver.findElement(By.xpath(xPath)));
		drplst.selectByVisibleText(input);
		}catch(Exception e) {e.printStackTrace();}	
	}

	public static List<WebElement> Element_list(String xPath) throws InterruptedException {
		try{Wait(xPath);
		List <WebElement> List_ele = driver.findElements(By.xpath(xPath));
		return List_ele;
		}catch(Exception e) {e.printStackTrace();}
		return null;	
	}


	public static boolean Element_Isdisplayed(String xPath) throws InterruptedException {
		try{Wait(xPath);
		boolean val= driver.findElement(By.xpath(xPath)).isDisplayed();return val;	}catch(Exception e) {e.printStackTrace();return false;}
			
	}

	public static void Browser_Close() throws InterruptedException {
		try{driver.close();}catch(Exception e) {e.printStackTrace();}

	}
	


}



