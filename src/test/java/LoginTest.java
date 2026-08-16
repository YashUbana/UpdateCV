import java.io.IOException;
import org.testng.annotations.Test;

import utils.Screenshoter;

public class LoginTest extends BaseTest {
	
	@Test
	public void login() throws IOException, InterruptedException {
		LoginPage page1 = new LoginPage(driver);
		
//		page1.loginclick1();
//		page1.email_txt();
//		page1.pass_txt();
//		page1.loginclick2();
		Thread.sleep(2000);
		page1.profilebtnclick();
		Screenshoter.takeScreenshot(driver, "LoginTest");
		Thread.sleep(4000);
		page1.deletefile();
		Screenshoter.takeScreenshot(driver, "LoginTest");
		page1.uploadfile();
		Thread.sleep(3000);
		Screenshoter.takeScreenshot(driver, "LoginTest");

	}
	
	
}
