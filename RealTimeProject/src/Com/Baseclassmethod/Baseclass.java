			package Com.Baseclassmethod;
			// Package 
			import java.util.concurrent.TimeUnit;

			import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
			import org.junit.Assert;
			import org.openqa.selenium.By;
			import org.openqa.selenium.WebDriver;
			import org.openqa.selenium.chrome.ChromeDriver;
			import org.openqa.selenium.firefox.FirefoxDriver;
			import org.openqa.selenium.ie.InternetExplorerDriver;
			import org.testng.annotations.AfterClass;
			import org.testng.annotations.AfterMethod;
			import org.testng.annotations.BeforeClass;
			import org.testng.annotations.BeforeMethod;
			//Import other utilities
			
			public class Baseclass {
			// Creating Method 
				
			public WebDriver driver;
			// Creating object
			
			public Exellibrary xlib;
			// Calling excel lib class
			
			public ProjectSpecificLibrary plib;
			// Calling plib class
				
			@BeforeClass
			public void openBrowser() {
				
			xlib=new Exellibrary();
						
			plib=new ProjectSpecificLibrary();
			
			/*		String browName=Xlib.getExcelData("Browser", 1, 0);
						
						if(browName.equals("firefox")) {
							
							driver=new FirefoxDriver();	
							
						}else if(browName.equals("chrome")) {
							
							System.setProperty("Webdriver.chrome.driver", "../exefiles/chromedriver.exe");
							driver=new ChromeDriver();	
							
						}else if(browName.equals("ie")) {
							
							System.setProperty("Webdriver.ie.driver", "../exefiles/IEDriverServer.exe");
							driver=new InternetExplorerDriver();
				
						}*/
						 
			WebDriver driver=new FirefoxDriver();
						
			driver.manage().window().maximize();
			driver.get("https://demo.actitime.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
			String expectedTitle="actiTIME - Login";
					
			String actualTitle=driver.getTitle();
					
			Assert.assertEquals(actualTitle, expectedTitle);
					
			System.out.println("Title Succes");
	}  
						 
		 	@BeforeMethod
			public void login() throws Exception {
						 
			String un=xlib.getExcelData("Login", 1, 0);
			String pw=xlib.getExcelData("Login", 1, 1);
						          
		 
			driver.findElement(By.id("username")).sendKeys(un);
			driver.findElement(By.name("pwd")).sendKeys(pw);	  
			driver.findElement(By.id("loginButton")).click();

			//Login data
 }
					
			@AfterMethod
			public void logout() {
			//Creating the logout method	
			driver.findElement(By.id("logoutLink")).click();
			// Logout path		  
}
			@AfterClass
			public void Closebrowser(){
			//Created method
    		driver.close();
}  			// Closing current browser
}
					
					


/*package Com.Baseclassmethod;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Baseclass {
	//This object will applicable entire this module
	public WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser () {
		  
	//System.out.println("OpenBrowser");
	//This method ends with in the are itself
	
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
  @BeforeMethod
	public void Login () {
	  
	//System.out.println("Login");
	
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	driver.findElement(By.id("loginButton")).click();
	  
  }
	  @AfterMethod
	public void Logout () {
			  
	driver.findElement(By.id("logoutLink")).click();
	  
	    driver.close();
			  
		  }	
  
}
*/