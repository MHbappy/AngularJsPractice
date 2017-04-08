package auto.amazon;

import java.awt.*;        // Using AWT container and component classes
import java.awt.event.*;  // Using AWT event classes and listener interfaces
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
// An AWT program inherits from the top-level container java.awt.Frame
public class AutoMain extends Frame implements ActionListener {
   private Label lblCount;    // Declare a Label component 
   private TextField email; // Declare a TextField component
   private TextField productCode;
   
   private Button btnCount;   // Declare a Button component
   private int count = 0;     // Counter's value
   
   private Button exitBtn;
 
   // Constructor to setup GUI components and event handlers
   public AutoMain() {
      setLayout(new FlowLayout());
 
      lblCount = new Label("Email");  // construct the Label component
      add(lblCount);                    // "super" Frame container adds Label component
 
      //email
      email = new TextField("", 20); // construct the TextField component
      email.setEditable(true);       // set to read-only
      add(email);                     // "super" Frame container adds TextField component
      
      
      lblCount = new Label("Code");  // construct the Label component
      add(lblCount);  
      
      //productCode
      productCode = new TextField("",20);
      email.setEditable(true); 
      add(productCode);
      
 
      btnCount = new Button("Hit !!!");   // construct the Button component
      
      add(btnCount);                    // "super" Frame container adds Button component
 
      btnCount.addActionListener(this);
      
      
      addWindowListener(new WindowAdapter(){  
          public void windowClosing(WindowEvent e) {  
              dispose();  
          }  
      }); 
      
 
      setTitle("AWT Counter");  // "super" Frame sets its title
      setSize(250, 200);        // "super" Frame sets its initial window size
 
      // For inspecting the Container/Components objects
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
 
      setVisible(true);         // "super" Frame shows
 
      // System.out.println(this);
      // System.out.println(lblCount);
      // System.out.println(tfCount);
      // System.out.println(btnCount);
   }
   
   
   public AutoMain(String info){
	   
   }
 
   // The entry main() method
   public static void main(String[] args) {
      // Invoke the constructor to setup the GUI, by allocating an instance
      AutoMain app = new AutoMain();
         // or simply "new AWTCounter();" for an anonymous instance
   }
 
   // ActionEvent handler - Called back upon button-click.
   @Override
   public void actionPerformed(ActionEvent evt) {
	   
	   AutoMain first = new AutoMain("hello");
	   
      ++count; // Increase the counter value
      // Display the counter value on the TextField tfCount
      String getValue = email.getText();
      
      email.setText(getValue); // Convert int to String
      System.out.println(productCode.getText());
      
      first.automationTools(email.getText(), productCode.getText());
   }
   
   public void automationTools(String email, String productCode) {
	   
	   //for windows
	   System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
	   
	   //for linux
	   //System.setProperty("webdriver.chrome.driver", "/usr/local/share/chromedriver");
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
        
        //searching by product Code
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productCode);
        
        //click search button
        driver.findElement(By.className("nav-input")).click();
        
        //detail
        driver.findElement(By.className("sx-price-whole")).click();
        
        //add to wishlist
        driver.findElement(By.id("add-to-wishlist-button-submit")).click();
        
        //add
        driver.findElement(By.className("w-button-text")).click();
        
   }
   
}