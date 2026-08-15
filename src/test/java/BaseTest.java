import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	public WebDriver driver;
	public ChromeOptions option;
	@BeforeMethod
	public void openbrowser() {
		
		option = new ChromeOptions() ;
		
		
		option.addArguments("--headless=new"); 
        option.addArguments("--no-sandbox");
        option.addArguments("--disable-dev-shm-usage");
        option.addArguments("--disable-blink-features=AutomationControlled");
        option.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
        
        
		
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		
		try {
			driver.get("https://www.naukri.com/");
			
			String rawJsonCookies = System.getenv("NAUKRI_JSON_COOKIES");
			
			if(rawJsonCookies == null || rawJsonCookies.trim().isEmpty()) {
				System.out.println("NAUKRI_JSON_COOKIES enviroment missing");
				return;
			}
			
			JSONArray cookieArray = new JSONArray(rawJsonCookies);
			
			for (int i = 0; i<cookieArray.length(); i++) {
				JSONObject jsonCookie = cookieArray.getJSONObject(i);
				
				String name = jsonCookie.getString("name");
				String value = jsonCookie.getString("value");
				
				String domain = jsonCookie.optString("domain", ".naukri.com");
				String path = jsonCookie.optString("path", "/");
				
				Cookie seleniumCookie = new Cookie.Builder(name, value)
										.domain(domain)
										.path(path)
										.isSecure(jsonCookie.optBoolean("secure", true))
										.build();
				driver.manage().addCookie(seleniumCookie);
												
				
			}
			
			driver.get("https://www.naukri.com/mnjuser/homepage");
			
			System.out.println("Bypassed OTP!");
			
			
		} catch (Exception e) {
			System.err.println("Automation failed: "+ e.getMessage());
			e.printStackTrace();
		}
		
		 
		
            
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




