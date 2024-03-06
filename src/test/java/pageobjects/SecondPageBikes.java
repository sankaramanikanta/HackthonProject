package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utiles.screenShot;

public class SecondPageBikes extends BasePage {
	
	 JavascriptExecutor js;
	 Scroll Sr;
	 public static String path;
	   //constructor
	   public SecondPageBikes(WebDriver driver){
		  super(driver);
		   
	   }
	   
	   @FindBy(name="makeId")
	   WebElement Manufacturer;
	   public void ManufacturerDrop() throws IOException, InterruptedException {
		   Manufacturer.click();
		   Thread.sleep(2000);
		   path=screenShot.takeScreenshot(driver, "Manufacturer");
	   }
	   
	   @FindBy(name="makeId")
	   WebElement Drp;
	   public void Drop() {
		   Select dropdown = new Select(Drp);
			dropdown.selectByVisibleText("Honda");
	   }
	   @FindBy(xpath="//*[@class=\"zw-sr-sortLevelFst zm-cmn-colorBlack\"]/li[2]/div[2]/div[4]")
		 WebElement ScrollUpto;
		 public void Scrollupto() {
			 Sr=new Scroll(driver);
			 Sr.scroll(ScrollUpto);
		 }
		 
		 By popularBrands=By.xpath("//*[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label");
		 public List<WebElement> GetBrands() {
			 return driver.findElements(popularBrands);
		 }
		 
		 public void Back() {
			 driver.navigate().back();
		 }
	   
}
