package PetstoreRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserr {
	
	
	
	public static WebDriver browserrr(String browser) {
		WebDriver driver=null;
		if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =  new ChromeDriver();
			
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver =  new ChromeDriver();
			
		}
		return driver;
		
	}

}
