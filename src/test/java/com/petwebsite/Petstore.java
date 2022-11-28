package com.petwebsite;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import PetstoreRepository.HomePage;
import PetstoreRepository.LoginPage;
import PetstoreRepository.RegisterPage;
import PetstoreRepository.Screenshot;
import PetstoreRepository.Browserr;
import PetstoreRepository.FishCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
/*
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;*/
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/*import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;*/

public class Petstore {
	static ExtentTest test;
    static ExtentReports report;


    
    @BeforeSuite
    public static void startTest() {
        report = new ExtentReports("target/" + "ExtentReportResults.html");
    }

	//@Test
	@Parameters({"brw"})
	public void login(String brw) throws InterruptedException, IOException {
		
		WebDriver driver = Browserr.browserrr(brw);
		
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		test = report.startTest("login");
		driver.get("https://petstore.octoperf.com/actions/Account.action");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Thread.sleep(3000);
		// C:\Users\Roshan.Jogi\eclipse-workspace
		
		//ASsert
		String ActualTitle = driver.getTitle();
        String ExpectedTitle = "JPetStore Demo";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        System.out.println("Assert passed");
        
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.registerNow().click();	
		
		
		test.log(LogStatus.PASS, "Registration link successfully clicked");
		
		
		Properties prop = new Properties();// get the property
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Roshan.Jogi\\eclipse-workspace\\com.petwebsite\\data.properties");
		prop.load(fis);
		RegisterPage rp = new RegisterPage(driver);
		// rl.userName().clear();
		rp.userName().sendKeys(prop.getProperty("username"));
		rp.password().sendKeys(prop.getProperty("password"));
		rp.repeatpass().sendKeys(prop.getProperty("password"));
		rp.fname().sendKeys(prop.getProperty("fname"));
		rp.lname().sendKeys(prop.getProperty("lname"));
		rp.email().sendKeys(prop.getProperty("email"));
		rp.phone().sendKeys(prop.getProperty("phone"));
		rp.add1().sendKeys(prop.getProperty("add1"));
		rp.add2().sendKeys(prop.getProperty("add2"));
		rp.city().sendKeys(prop.getProperty("city"));
		rp.state().sendKeys(prop.getProperty("state"));
		rp.zip().sendKeys(prop.getProperty("zip"));
		rp.country().sendKeys(prop.getProperty("country"));

		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		rp.signIn().click();
		test.log(LogStatus.PASS, "Registration successful");
        Screenshot.takeScreenShot("successful registration", driver);


		
		rp.home().click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Thread.sleep(3000);

		Properties prop1 = new Properties();// get the property
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\Roshan.Jogi\\eclipse-workspace\\com.petwebsite\\data.properties");
		prop1.load(fis1);
		LoginPage rl = new LoginPage(driver);
		rl.userName().clear();
		rl.userName().sendKeys(prop1.getProperty("username"));
		rl.password().clear();
		rl.password().sendKeys(prop1.getProperty("password"));
		rl.loginbutton().click();
		
		test.log(LogStatus.PASS, "login successful");
		
        Screenshot.takeScreenShot("successful login", driver);


		
		//validation
		if(rl.logout().isDisplayed())
        {
            System.out.println("Login Successful");
        Screenshot.takeScreenShot("LoginTestCase_Login_Successful", driver);
        test.log(LogStatus.PASS, "LoginTestCase_Login_Successful"); 
        }
		else {
	        Screenshot.takeScreenShot("LoginTestCase_Login_Unsuccessful", driver);

			System.out.println("Login unsuccessful check if the login credentials are correct");
		}
		
		
		//Screenshot
		String filename = "photo1";
		Screenshot.takeScreenShot(filename, driver);

		Properties prop2 = new Properties();// get the property
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\Roshan.Jogi\\eclipse-workspace\\com.petwebsite\\data.properties");
		prop2.load(fis2);
		FishCart fc = new FishCart(driver);
		fc.Fish().click();
		fc.ProdId().click();
		fc.Addcart().click();
		
		test.log(LogStatus.PASS, "Item added");
        Screenshot.takeScreenShot("Added items", driver);


		fc.Checkout().click();
		fc.Contnue().click();
		fc.Confirm().click();
		
	}
	
	@Test(priority=1)
	@Parameters({"brw"})
	public void placeOrder(String brw) throws IOException {
		
		WebDriver driver = Browserr.browserrr(brw);
		 driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			test = report.startTest("login");
			driver.get("https://petstore.octoperf.com/actions/Account.action");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		Properties prop1 = new Properties();// get the property
		FileInputStream fis1 = new FileInputStream(
				"C:\\Users\\Roshan.Jogi\\eclipse-workspace\\com.petwebsite\\data.properties");
		prop1.load(fis1);
		LoginPage rl = new LoginPage(driver);
		rl.userName().clear();
		rl.userName().sendKeys(prop1.getProperty("username"));
		rl.password().clear();
		rl.password().sendKeys(prop1.getProperty("password"));
		rl.loginbutton().click();
		WebElement elem=null;
		try {
			elem=driver.findElement(By.id("WelcomeContent"));
		}catch(Exception e) {
			System.out.println("login fail...");
		}
		assertTrue(elem!=null,"login unsuccesful");//----------------------------------------------------------
		
		test.log(LogStatus.PASS, "login successful");
		
        Screenshot.takeScreenShot("successful login", driver);


		
		//validation
		if(rl.logout().isDisplayed())
        {
            System.out.println("Login Successful");
        Screenshot.takeScreenShot("LoginTestCase_Login_Successful", driver);
        test.log(LogStatus.PASS, "LoginTestCase_Login_Successful"); 
        }
		else {
	        Screenshot.takeScreenShot("LoginTestCase_Login_Unsuccessful", driver);

			System.out.println("Login unsuccessful check if the login credentials are correct");
		}
		
		
		//Screenshot
		String filename = "photo1";
		Screenshot.takeScreenShot(filename, driver);

		Properties prop2 = new Properties();// get the property
		FileInputStream fis2 = new FileInputStream(
				"C:\\Users\\Roshan.Jogi\\eclipse-workspace\\com.petwebsite\\data.properties");
		prop2.load(fis2);
		FishCart fc = new FishCart(driver);
		fc.Fish().click();
		fc.ProdId().click();
		fc.Addcart().click();
		
		test.log(LogStatus.PASS, "Item added");
        Screenshot.takeScreenShot("Added items", driver);


		fc.Checkout().click();
		fc.Contnue().click();
		fc.Confirm().click();
	}
	
//	@AfterTest
//    public  void endTest() 
//    {
//        report.endTest(test);
//        report.flush();
//        }
	
	@AfterSuite
    public static void endTest() {
        report.endTest(test);
        report.flush();
    }

}
