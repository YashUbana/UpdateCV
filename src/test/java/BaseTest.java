import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.CookieInjector;
import utils.Screenshoter;

public class BaseTest {
	
	public WebDriver driver;
	public ChromeOptions option;
	public WebDriverWait wait;
	@BeforeMethod
	public void openbrowser() {
		
		option = new ChromeOptions() ;
		
		option.addArguments("--start-maximized");
		option.addArguments("--headless=new"); 
        option.addArguments("--no-sandbox");
        option.addArguments("--disable-dev-shm-usage");
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
        
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		CookieInjector.CookieInject(driver);
		
		Screenshoter.takeScreenshot(driver, "BaseTest");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='view-profile-wrapper']/a")));
		
		Screenshoter.takeScreenshot(driver, "BaseTest");
		
            
	}
	
	
//	@AfterMethod
	public void closeit() throws InterruptedException {
		if(driver != null) {
			Thread.sleep(2000);
			driver.quit();
		}else {
			System.out.println("Browser not found");
		}
	}
	
	
	
	
	
	
	
}




