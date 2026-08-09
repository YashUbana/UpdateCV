import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class LoginPage extends BasePage {
	
	private final By loginbutton = By.xpath("//a[@id = 'login_Layer']");
	private final By email = By.xpath("//input[@aria-label='Email ID / Username']");
	private final By password = By.xpath("//input[@aria-label='Password']");
	private final By login = By.xpath("//button[@class=\"btn-primary loginButton\"]");
	private final By profile = By.xpath("//div[@class='view-profile-wrapper']/a");
	private final By fileupload = By.xpath("//input[@id='attachCV']");
	private final By deletebtn1 = By.xpath("//span[@data-title='delete-resume']");
	private final By deletebtn2 = By.xpath("(//button[@class='btn-dark-ot'][normalize-space()='Delete'])[2]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	protected void loginclick1() {
		WebElement loginBtn1 = findElementWithClickWait(loginbutton);
		click(loginBtn1);
	}
	
	protected void email_txt() {
		WebElement emailinput = findElementWithClickWait(email);
		writeinput(emailinput, "yashubana789@gmail.com");
	}
	
	protected void pass_txt() {
		WebElement passwordinput = findElementWithClickWait(password);
		writeinput(passwordinput, "Yash@1234");
	}
	
	protected void loginclick2() {
		WebElement loginBtn2 = findElementWithClickWait(login);
		click(loginBtn2);
	}
	
	protected void profilebtnclick() {
		
		try {
			WebElement profilebtnElement = findElementWithClickWait(profile);
			click(profilebtnElement);
		} catch (Exception e) {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    
		    // Save it directly into the target directory
		    try {
				FileHandler.copy(srcFile, new File("error-screenshot.png"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    throw e; 
		}
		
	}
	
	protected void deletefile() {
		
		WebElement deletebtnElement1 = findElementWithClickWait(deletebtn1);
		click(deletebtnElement1);
		WebElement deletebtnElement2 = findElementWithClickWait(deletebtn2);
		click(deletebtnElement2);
		
	}
	
	protected void uploadfile() {
//		WebElement fileuploadElement = driver.findElement(fileupload);
		String directry = "D:\\Yash_ResumeA.pdf";
		uploadfile(fileupload, directry);
	}
			
			
			
			
}
