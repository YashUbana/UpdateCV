import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
		WebElement loginBtn1 = driver.findElement(loginbutton);
		click(loginBtn1);
	}
	
	protected void email_txt() {
		WebElement emailinput = driver.findElement(email);
		writeinput(emailinput, "yashubana789@gmail.com");
	}
	
	protected void pass_txt() {
		WebElement passwordinput = driver.findElement(password);
		writeinput(passwordinput, "Yash@1234");
	}
	
	protected void loginclick2() {
		WebElement loginBtn2 = driver.findElement(login);
		click(loginBtn2);
	}
	
	protected void profilebtnclick() {
		WebElement profilebtnElement = driver.findElement(profile);
		click(profilebtnElement);
	}
	
	protected void deletefile() {
		
		WebElement deletebtnElement1 = driver.findElement(deletebtn1);
		WebElement deletebtnElement2 = driver.findElement(deletebtn2);
		
		click(deletebtnElement1);
		click(deletebtnElement2);
		
	}
	
	protected void uploadfile() {
//		WebElement fileuploadElement = driver.findElement(fileupload);
		String directry = "D:\\Testing.pdf";
		uploadfile(fileupload, directry);
	}
			
			
			
			
}
