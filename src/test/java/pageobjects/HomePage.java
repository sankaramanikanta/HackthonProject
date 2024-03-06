package pageobjects;
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
public class HomePage extends BasePage {
	//WebDriver driver;
	JavascriptExecutor js;
	Scroll Sr;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
 
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	Actions act = new Actions(driver);
	//JavascriptExecutor js = (JavascriptExecutor) driver;
 
	@FindBy(id = "forum_login_wrap_lg")
	WebElement signin;
 
	@FindBy(xpath = "(//div[@class='newgf-login'])[2]")
	WebElement google;
 
	@FindBy(xpath = "//a[contains(text(), 'New Bikes')]")
	WebElement newbikes;
 
	@FindBy(xpath = "//span[contains(text(), 'Upcoming Bikes')]")
	WebElement upcomingbikes;
 
	@FindBy(xpath = "(//a[@class='c-p'])[4]")
	WebElement usedcars;
 
	@FindBy(id = "report_submit_close_login")
	WebElement closelogin;
 
	@FindBy(id = "headerSearch")
	WebElement search;
 
	@FindBy(xpath = "//span[@class='h-s-v1 h-srh-i abs i-b c-p']")
	WebElement searching;
 
	@FindBy(id = "forum_login_title_lg")
	WebElement signinbutton;
 
	@FindBy(xpath = "//h1[@class='pl-15 pr-15']")
	WebElement honda;
 
	@FindBy(xpath = "(//span[contains(text(),'Chennai')])[1]")
	WebElement chennai;
 
	@FindBy(xpath = "//div[@class='h-dd-r']/ul/li")
	List<WebElement> city;
 
	@FindBy(id = "usedcarttlID")
	WebElement usedcarcity;
 
	public void zigwheelspage() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com");
		System.out.println("Zigwheels Page is Opened without any errors");
	}
 
	public void signinbuttonverification() {
		Boolean k = signinbutton.isDisplayed();
		Assert.assertEquals(true, k);
		System.out.println("Login/Signin button is present");
	}
 
	public void clickingonsignin() {
		signin.click();
	}
 
	public void verifyingsiginpage() {
		Boolean o = google.isDisplayed();
		Assert.assertEquals(true, o);
		System.out.println("Login/Register page is opened");
		closelogin.click();
	}
 
	public void searchbutton() {
		search.sendKeys("Honda Bikes");
		searching.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
 
	public void checkingforhondabikes() {
		Boolean e = honda.isDisplayed();
		Assert.assertEquals(true, e);
		System.out.println("Honda Bikes are present");
	}
 
	public void newbikeschecking() {
		Boolean h = newbikes.isDisplayed();
		Assert.assertEquals(true, h);
		System.out.println("New Bikes is present");
	}
 
	public void Newbikes() {
		act.moveToElement(newbikes).perform();
	}
 
	public void upcomingbikes() {
		wait.until(ExpectedConditions.elementToBeClickable(upcomingbikes));
		Assert.assertEquals(true, upcomingbikes.isDisplayed());
		System.out.println("Upcoming bikes option is there");
	}
 
	public void Usedcars2() {
		usedcars.click();
	}
 
	public void usedcarschecking() {
		String u = driver.getTitle();
		Assert.assertEquals(u, "Used Cars for Sale, Buy Second Hand Cars in India @ Zigwheels");
		System.out.println("Succesfully navigated to used cars");
	}
 
	public void Usedcars1() {
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		act.moveToElement(usedcars).perform();
	}
 
	public void Chennai() {
		//wait.until(ExpectedConditions.elementToBeClickable(chennai));
		act.moveToElement(chennai).click().perform();
	}
 
	public void city(String c) {
		int size = city.size();
		for (int i = 0; i < size; i++) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			act.moveToElement(usedcars).perform();
			if (c.equalsIgnoreCase(city.get(i).getText())) {
				//wait.until(ExpectedConditions.elementToBeClickable(city.get(i)));
				act.moveToElement(city.get(i)).click().perform();
				break;
			}
		}
	}
 
	public void check(String h) {
		Boolean r = usedcarcity.isDisplayed();
		Assert.assertEquals(true, r);
		System.out.println(usedcarcity.getText());
		driver.navigate().back();
 
	}
 
}