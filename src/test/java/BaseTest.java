import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	public ChromeOptions option;
	@BeforeMethod
	public void openbrowser() {
		option = new ChromeOptions() ;
		option.addArguments("--headless=new");
		option.addArguments("--window-size=1920,1080");
	    option.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36 Edg/120.0.0.0");

	    option.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
		option.addArguments("--disable-blink-features=AutomationControlled");
		option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		option.setExperimentalOption("useAutomationExtension", false);

		driver = new ChromeDriver(option);
		driver.get("http://www.naukri.com/");
//		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void closeit() throws InterruptedException {
		if(driver != null) {
			Thread.sleep(2000);
			driver.quit();
		}else {
			System.out.println("Browser not found");
		}
	}
	
	
	
	
	
}
