import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	
	@Test
	public void login() throws IOException {
		LoginPage page1 = new LoginPage(driver);
		page1.loginclick1();
		page1.email_txt();
		page1.pass_txt();
		page1.loginclick2();
		page1.profilebtnclick();
		page1.deletefile();
		page1.uploadfile();
	}
	
	
}
