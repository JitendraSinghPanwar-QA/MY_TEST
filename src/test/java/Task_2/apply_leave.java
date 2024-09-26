package Task_2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class apply_leave {

	
	public String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
        System.out.println("Before Test Executed");
		driver=new ChromeDriver();
		
		//Maximize Windows
		driver.manage().window().maximize();
		
		//Open URL
		driver.get(baseUrl);
		
		//Wait Timer
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
	}
		
		@Test(priority=1)
		public void loginTest()
		
		{
			//find User name and enter user name "Admin"
			
		    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
			
			//find Password and enter password "admin123"
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
			
			//Click on Log-In button
			driver.findElement(By.xpath("//button[@type='submit']")).submit();
			
			
		    //Verify if the login was successful by checking the page title
		 	String pageTitle = driver.getTitle();
			
			if (pageTitle.equals("OrangeHRM")) 
			{
				System.out.println("Login Successful ...");
			}
			else 
			{
					System.out.println("Login failed...");
			}
			
						
			}
			
		
	
		@Test(priority=2)
		public void applyLeave() throws InterruptedException
		
		{
		
						
			//click on Leave menu
			driver.findElement(By.linkText("Leave")).click();
			
			//click on Apply menu
			driver.findElement(By.linkText("Apply")).click();
			
			//click on Leave type drop down menu
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")).click();
			
			//Select CAN-FMLA option from leave type drop down
			driver.findElement(By.xpath("//*[contains(text(),'CAN - FMLA')]")).click();
			Thread.sleep(2000);
			
			//Enter "From Date"
		    driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("2024-16-09");
			
			
            //Enter "T0 Date"
			WebElement element= driver.findElement(By.xpath("//label[text()='To Date']/following::input"));
		
			element.sendKeys(Keys.CONTROL,"a");
			element.sendKeys(Keys.DELETE);
		
			
			element.sendKeys("2024-09-20");
			Thread.sleep(2000);
			
			
      		//Enter Comment
			driver.findElement(By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")).sendKeys("On Sick Leave");
			
			//Click on Apply button
	     	driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			}
			
	
	
		@AfterTest
		public void tearDown() throws InterruptedException
		{
			Thread.sleep(5000);  // wait for 5 Second before quit
			
			driver.quit();
			//driver.close();
		
	}
}

