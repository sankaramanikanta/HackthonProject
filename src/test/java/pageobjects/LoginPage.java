package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utiles.screenShot;

public class LoginPage extends BasePage {
	
	//Constructor
	public static String path;
	public LoginPage(WebDriver driver){
		super(driver);
	}
   @FindBy(xpath="//*[@class=\"lgn-sp s ggle\"]")
   WebElement GoogleBtn;
   public void ClickGoogle() {
	   GoogleBtn.click();
   }
   @FindBy(xpath="//input[@autocomplete=\"username\"]")
   WebElement Email;
   public void EnterEmail() throws IOException {
	   Email.sendKeys("abcxyzdefuvw918@gmail.com");
	   path=screenShot.takeScreenshot(driver, "EmailEntered");
   }
   @FindBy(xpath="//span[text()=\"Next\"]")
   WebElement NextBtn;
   public void ClickNext() {
	   NextBtn.click();
   }
   @FindBy(xpath="//div[text()='Couldn’t find your Google Account']")
   WebElement ErrorTxt;
   public void ErrorMsg() throws IOException {
	   System.out.println(ErrorTxt.getText());
	   path=screenShot.takeScreenshot(driver, "ErrorMessage");
   }
   
   public void Lgnwindow() throws IOException {
	   Set<String>NewWindow= driver.getWindowHandles();
		List<String>GoogleWindow=new ArrayList<String>(NewWindow);
		driver.switchTo().window(GoogleWindow.get(1));
		path=screenShot.takeScreenshot(driver, "LoginWindow");
   }
}
