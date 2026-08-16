package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieInjector {
	
	public static void CookieInject(WebDriver driver) {
		
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
			
			driver.navigate().refresh();
			
			System.out.println("Bypassed OTP!");
			
			
		} catch (Exception e) {
			System.err.println("Automation failed: "+ e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	

}
