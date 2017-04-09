package auto.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPurpose {
	
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
		   
		   
	       WebDriver driver = new ChromeDriver();
	       
	     //initialize Chrome driver
	       //System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-2.35.0\\chromedriver_win32_2.2\\chromedriver.exe");        
	       // WebDriver driver = new ChromeDriver(); 
	         
	        //Open gmail
	        //driver.get("https://www.amazon.com");
	        
	        
	        	driver.get("https://www.amazon.com/gp/product/B06Y58NKJ3/ref=ox_sc_act_title_1?ie=UTF8&smid=A2P1PBI4HRK396&th=1");
	        	
//	        	driver.findElement(By.cssSelector("i.a-icon.a-icon-share-email")).click();
//	        	
//	        	driver.findElement(By.id("swfSubmitButton-announce")).click();
	        	

	        	
	        	driver.quit();

	        	
	        	
	        	
	}
	
}
