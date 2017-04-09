package auto.amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoAma {
	
	   public void automationTools(String email, String password, String link) {
		   
		   //for windows
		   //System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
		   
		   //for linux
		   System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
		   
		   
	       WebDriver driver = new ChromeDriver();
	       
	     //initialize Chrome driver
	       //System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-2.35.0\\chromedriver_win32_2.2\\chromedriver.exe");        
	       // WebDriver driver = new ChromeDriver();
	         
	        //Open gmail
	        driver.get("https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_signin");
	        
	        //driver.get("https://amazon.com");
	        
	        
	        // Enter userd id
	        WebElement element = driver.findElement(By.id("ap_email"));
	        element.sendKeys(email);
	         
	        //wait 5 secs for  userid to be entered
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	         
	        //Enter Password
	        
	        
	        
	        WebElement element1 = driver.findElement(By.id("ap_password"));
	        element1.sendKeys("654321tM$");
	         
	        //Submit button
	        element.submit();
	        
	        driver.get("https://www.amazon.com/Adapter-Aluminium-Topoint-External-Converter/dp/B01KJS1W1I/ref=s9u_wsim_gw_i5?_encoding=UTF8&fpl=fresh&pd_rd_i=B01KJS1W1I&pd_rd_r=XCD4BKB7RWA7YB6H7GN1&pd_rd_w=jiYxj&pd_rd_wg=wIQ3p&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=RJ6WZJGKMMVE7TXE4GSK&pf_rd_t=36701&pf_rd_p=781f4767-b4d4-466b-8c26-2639359664eb&pf_rd_i=desktop");
	        
	        //driver.get("");
	        
	        //searching by product Code
	        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productCode);
	        
	        //click search button
	        //driver.findElement(By.className("nav-input")).click();
	        
	        //detail
	        //driver.findElement(By.className("sx-price-whole")).click();
	        
	        
	        
	        //add to wishlist
	        driver.findElement(By.id("add-to-wishlist-button-submit")).click();
	        
	        //add
	        driver.findElement(By.className("w-button-text")).click();
	        
	        //sharebutton
	        driver.findElement(By.cssSelector("i.a-icon.a-icon-share-email")).click();
	    	
	    	driver.findElement(By.id("swfSubmitButton-announce")).click();
	    	
	    	try {
				Thread.sleep(5000);
				driver.quit();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	
	   }

}
