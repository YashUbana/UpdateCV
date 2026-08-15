import java.io.IOException;
import org.testng.annotations.Test;

import utils.Screenshoter;

public class LoginTest extends BaseTest {
	
	@Test
	public void login() throws IOException {
		LoginPage page1 = new LoginPage(driver);
		
//		page1.loginclick1();
//		page1.email_txt();
//		page1.pass_txt();
//		page1.loginclick2();
		page1.profilebtnclick();
		Screenshoter.takeScreenshot(driver, "LoginTest");
		page1.deletefile();
		Screenshoter.takeScreenshot(driver, "LoginTest");
		page1.uploadfile();
		Screenshoter.takeScreenshot(driver, "LoginTest");

	}
	
	
}
