package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshoter {
	
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
		
		try {
		File screenshotFolder = new File("screenshots");
		if(!screenshotFolder.exists()) {
			screenshotFolder.mkdir();
		}
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
		
		String finalFileName = "screenshots/"+screenshotName+"_"+timestamp+ ".png";
		
		File destFile = new File(finalFileName);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Screenshot captured at - "+destFile.getAbsolutePath());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
