package PetstoreRepository;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

public class Screenshot {
	
	
	public static void takeScreenShot(String fileName, WebDriver driver) {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();

		// getting the browser name
		String browserName = cap.getBrowserName();

		// removing all the space
		fileName = fileName.trim().replaceAll(" ", "");

		// attaching the screenshot taken time as well as browser name
		fileName = fileName + "_" + browserName + "_" + System.currentTimeMillis();

		System.out.println(fileName);

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		try {
			Files.copy(SrcFile, new File("screenshot/" + fileName + ".png"));
			System.out.println("Screenshot taken");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
