import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public WebElement findElementWithClickWait(By element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public WebElement  waitTillElementIsVisible(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}
	
	public void click(WebElement btn) {
		wait.until(ExpectedConditions.visibilityOf(btn)).click();
	}
	
	public void writeinput(WebElement input, String str) {
		wait.until(ExpectedConditions.visibilityOf(input)).sendKeys(str);
	}
	
	public void uploadfile(By input, String str) {
		wait.until(ExpectedConditions.presenceOfElementLocated(input)).sendKeys(str);
	}
}



