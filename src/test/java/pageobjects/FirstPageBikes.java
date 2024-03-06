package pageobjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utiles.screenShot;

public class FirstPageBikes extends BasePage {
	
		JavascriptExecutor js;
		Scroll Sr;
		public static String path;
	 public FirstPageBikes(WebDriver driver){
		super(driver);
	}
	 @FindBy(xpath="//*[@class=\"zw i-b mt-10 pt-2 zw-srch-logo\"]")
	 WebElement Logo;
	 public boolean VerifyLogo() {
		 return Logo.isDisplayed();
	 }
	 
	 @FindBy(linkText ="New Bikes")
	 WebElement NewBikes;
	 public void clickNewBikes() throws IOException {
			Actions builder = new Actions(driver);
			builder.moveToElement(NewBikes).build().perform();
			path=screenShot.takeScreenshot(driver, "NewBikes");
	 }
	 
	 @FindBy(xpath ="//span[text()='Upcoming Bikes']")
	 WebElement UpcomingBikes;
	 public void UpcomingNewBikes() {
		 UpcomingBikes.click();
	 }
	 
	 @FindBy(id="des_lIcon")
	 WebElement Login;
	 public void LgBtn() {
		 Login.click();
		 
	 }
	 
}
