package bikesMain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import pageobjects.FirstPageBikes;
import pageobjects.LoginPage;
import pageobjects.Scroll;
import pageobjects.SecondPageBikes;
import pageobjects.ThirdPageBikes;
import utiles.ExcelUtiles;
 
public class DisplayNewBikes extends Basetestng{
	//WebDriver driver;
	public FirstPageBikes Fp;
	public SecondPageBikes Sp;
	public ThirdPageBikes Tp;
	public LoginPage Lp;
	public static String path;
	JavascriptExecutor js;
	Scroll Sr;
	List<String> ModelNames=new ArrayList<String>();
	List<String> ExpectedPrice=new ArrayList<String>();
	List<String> ExpectedLaunch=new ArrayList<String>();
	List<String> PopularBrands =new ArrayList<String>();

	@Test(priority=0,groups= {"smoke"})
	public void NewBikes() throws IOException
	{
		Fp=new FirstPageBikes(driver);
		Fp.VerifyLogo();
		Assert.assertEquals(true, Fp.VerifyLogo());
		Fp.clickNewBikes();
	}
	@Test(priority=1,groups= {"smoke"})
	public void UpcomingBikes() {
		Fp=new FirstPageBikes(driver);
		Fp.UpcomingNewBikes();
		logger.info("clicked on newbikes and selected upcoming bikes ");
	}
	@Test(priority=2)
	public void ManufacturerDrop() throws IOException, InterruptedException
	{
		Sp=new SecondPageBikes(driver);
		Sp.ManufacturerDrop();
		logger.info("select dropdown");
	}
@Test(priority=3)
	public void ClickHonda() {
	Sp=new SecondPageBikes(driver);
	logger.info("clicked honda in dropdown");
      Sp.Drop();
	}
@Test(priority=4)
public void Viewmore() throws IOException {
	Tp=new ThirdPageBikes(driver);
	logger.info("scrolling to view more filters");
	Tp.ScrollView();
	Tp.ClickRead();
}
 
@Test(priority=5)
public void ModelName() throws InterruptedException, IOException {
	 Tp=new ThirdPageBikes(driver);
	 List<WebElement> Modelnames= Tp.ModelNames();
	 List<WebElement> Price=Tp.MPrice();
	 List<WebElement> ExDate=Tp.MDate();
	 logger.info("printing the upcoming honda bikes under 4 lakh");
	 for(int i=0;i<Modelnames.size();i++) {
		String amount=Price.get(i).getText();
		String price = amount.replaceAll("[^\\d.]", "").replaceFirst("\\.(?=.*\\.)", "");
		double number=(Double.parseDouble(price));
		if(number < 4) {
		System.out.println(Modelnames.get(i).getText()+"-->"+Price.get(i).getText()+"-->"+ExDate.get(i).getText());
		ModelNames.add(Modelnames.get(i).getText());
		ExpectedPrice.add(Price.get(i).getText());
		ExpectedLaunch.add(ExDate.get(i).getText());
		}	
	}
	 driver.navigate().back();
	 logger.info("Navigate to second page");
}
@Test(priority=6)
public void Usedcars() throws IOException {
	Tp=new ThirdPageBikes(driver);
	logger.info("click on usedCars ");
	Tp.HoverUsedCars();
}
@Test(priority=7)
public void clickChennai() throws IOException {
	Tp=new ThirdPageBikes(driver);
	logger.info("Click chennai as city");
	Tp.clickChennai();
}
@Test(priority=8)
public void GetCarBrands() throws IOException {
	Sp=new SecondPageBikes(driver);
	Sp.Scrollupto();
	logger.info("scrolling to popularmodels;");

	List<WebElement> Popularbrands=Sp.GetBrands();
	System.out.println("Popular UsedCars Brands in Chennai are :");
	for(int i=0;i<Popularbrands.size();i++) {
		System.out.println(Popularbrands.get(i).getText());
		PopularBrands.add(Popularbrands.get(i).getText());
	}
	driver.navigate().back();
	ExcelUtiles.saveBikesData(ModelNames, ExpectedPrice, ExpectedLaunch);
	ExcelUtiles.SaveCarsData(PopularBrands);
	ExcelUtiles.closeExcel();
}
@Test(priority=9,groups= {"smoke"})
public void login() {
	Fp=new FirstPageBikes(driver);
	logger.info("Clicking login button");
	Fp.LgBtn();
}
 
@Test(priority=10,groups= {"smoke"})
public void Google() throws InterruptedException {
	Lp=new LoginPage(driver);
	Thread.sleep(5000);
	logger.info("Click on the google");
	Lp.ClickGoogle();
}
@Test(priority=11,groups= {"smoke"})
public void Lognwndw() throws InterruptedException, IOException {
 
	Lp=new LoginPage(driver);
	Lp.Lgnwindow();
    logger.info("Opening new Window");
	System.out.println("opening New Window :");

	Thread.sleep(3000);
}
@Test(priority=12,groups= {"smoke"})
public void EnterDetails() throws InterruptedException, IOException {
	Lp=new LoginPage(driver);
	Thread.sleep(3000);
	Lp.EnterEmail();
    logger.info("Entering Email");

}
@Test(priority=13,groups= {"smoke"})
public void ErrorMsg() throws IOException {
	Lp=new LoginPage(driver);
	Lp.ClickNext();
	logger.info("Clicking Next");
	Lp.ErrorMsg();
	logger.info("Error Msg Captured");
}
 
}


	
	
	
	