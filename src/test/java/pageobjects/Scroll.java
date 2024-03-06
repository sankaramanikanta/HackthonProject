package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll extends BasePage {
	JavascriptExecutor js;
	
	
	public Scroll(WebDriver driver){
		super(driver);
	}
	public void scroll(WebElement ele)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments [0].scrollIntoView();",ele);
	}
	public void Click(WebElement ele)
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments [0].click();",ele);
	}

}
