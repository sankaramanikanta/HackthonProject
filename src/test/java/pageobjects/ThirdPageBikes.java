package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utiles.screenShot;

public class ThirdPageBikes extends BasePage{
	
	JavascriptExecutor js;
	Scroll Sr;
	public static String path; 
	   //constructor
	   public ThirdPageBikes(WebDriver driver){
		   super(driver);
		}
	   
	   @FindBy(xpath="//*[contains(text(),'View More Bikes ')]")
	   WebElement View;
	   public void ClickRead() {
		   Sr=new Scroll(driver);
			Sr.Click(View);
	   }	
		
		@FindBy(xpath="//*[@class=\"b fnt-18 c-blk \"]")
	    WebElement ScrollTo;
		public void ScrollView() throws IOException {
		Sr=new Scroll(driver);
		Sr.scroll(ScrollTo);
		path=screenShot.takeScreenshot(driver,"Upcoming honda Bikes");	
		}
		
		By ModelName = By.xpath("//*[@id=\"modelList\"]//div/div[3]/a");
		public List<WebElement> ModelNames(){
		return driver.findElements(ModelName);
		}
		
		By Mprice = By.xpath("//*[@id=\"modelList\"]//div/div[3]//a//following-sibling::div[1]");
		public List<WebElement> MPrice(){
		return driver.findElements(Mprice);
		}
		
		By MDate = By.xpath("//*[@id=\"modelList\"]//div/div[3]//a//following-sibling::div[2]");
		public List<WebElement> MDate(){
		return driver.findElements(MDate);
		}
		
		@FindBy(linkText ="Used Cars")
		 WebElement UsedCars;
		 public void HoverUsedCars() throws IOException {	 
		 Actions builder = new Actions(driver);
		 builder.moveToElement(UsedCars).build().perform();
		 path=screenShot.takeScreenshot(driver,"UsedCars");
		 }
		 
		 @FindBy(xpath ="//*[@class=\"h-dd-r\"]//li[4]/span")
		 WebElement ClickChennai;
		 public void clickChennai() {
			 ClickChennai.click();
		 }
		 
		 public void Back() {
			 driver.navigate().back();
		 }
}
