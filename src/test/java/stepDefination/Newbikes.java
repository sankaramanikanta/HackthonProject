package stepDefination;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumberBase.CucmberBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.FirstPageBikes;
import pageobjects.LoginPage;
import pageobjects.Scroll;
import pageobjects.SecondPageBikes;
import pageobjects.ThirdPageBikes;
import utiles.ExcelUtiles;

public class Newbikes  {
	WebDriver driver;
	public FirstPageBikes Fp;
	public SecondPageBikes Sp;
	public ThirdPageBikes Tp;
	public LoginPage Lp;
	public Logger logger= LogManager.getLogger(this.getClass());;
	JavascriptExecutor js;
	Scroll Sr;
	public static String path;
	public List<String> ModelNames=new ArrayList<String>();
	public List<String> ExpectedPrice=new ArrayList<String>();
	public List<String> ExpectedLaunch=new ArrayList<String>();
	public List<String> PopularBrands =new ArrayList<String>();
	
	@Given("the user is on the zigwheels.com page")
	public void the_user_is_on_the_zigwheels_com_page() throws IOException {
		Fp=new FirstPageBikes(CucmberBase.getDriver());
		System.out.println("Website opened");
		
		logger.info("Website opened");
	}

	@When("the user moves mouse on to the newbikes")
	public void the_user_moves_mouse_on_to_the_newbikes() throws IOException {
		
		Fp.clickNewBikes();
	   
	}

	@When("click the upcomingbikes")
	public void click_the_upcomingbikes() {
		
		Fp.UpcomingNewBikes();
		logger.info("clicked on newbikes and selected upcoming bikes ");
	}
	
	@When("user open the manufacturer dropdown")
	public void user_open_the_manufacturer_dropdown() throws IOException, InterruptedException {

		Sp=new SecondPageBikes(CucmberBase.getDriver());
		Sp.ManufacturerDrop();
		logger.info("select dropdown");
		
	}

	@When("user select the honda in manufacturer")
	public void user_select_the_honda_in_manufacturer() {
		logger.info("clicked honda in dropdown");
		Sp.Drop();
	}

	@Then("user scrolldown and click view all filters")
	public void user_scrolldown_and_click_view_all_filters() throws IOException {
		Tp=new ThirdPageBikes(CucmberBase.getDriver());
		logger.info("scrolling to view more filters");
		Tp.ScrollView();
		
		Tp.ClickRead();
	}

	@Then("user print the details of upcoming honda bikes below {int} lakh")
	public void user_print_the_details_of_upcoming_honda_bikes_below_lakh(Integer int1) throws FileNotFoundException {
		 List<WebElement> Modelnames= Tp.ModelNames();
		 List<WebElement> Price=Tp.MPrice();
		 List<WebElement> ExDate=Tp.MDate();
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
		 ExcelUtiles.saveBikesData(ModelNames, ExpectedPrice, ExpectedLaunch);
	}

	@Then("user navigates to the homepages")
	public void user_navigates_to_the_homepages() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("Bikes are printed");
		 Tp=new ThirdPageBikes(CucmberBase.getDriver());
		 logger.info("Navigate to Home page");
		    Tp.Back();
		    Tp.Back();
		 
	}
	
	@Given("User moves mouse to usedcars section")
	public void user_moves_mouse_to_usedcars_section() throws IOException {
		Tp=new ThirdPageBikes(CucmberBase.getDriver());
		logger.info("click on usedCars ");
	    Tp.HoverUsedCars();
	   
	}

	@When("user click the chennai as city")
	public void user_click_the_chennai_as_city() {
	    Tp.clickChennai();
	    logger.info("Click chennai as city");
	}

	@Then("redirected to usedcars page and scroll down to popular models")
	public void redirected_to_usedcars_page_and_scroll_down_to_popular_models() {
		Sp=new SecondPageBikes(CucmberBase.getDriver());
	    Sp.Scrollupto();
	    logger.info("scrolling to popularmodels;");
	}

	@Then("user retrieve the list of popular Usedcars models in chennai")
	public void user_retrieve_the_list_of_popular_usedcars_models_in_chennai() throws IOException {
		List<WebElement> Popularbrands=Sp.GetBrands();
		System.out.println("Popular UsedCars Brands in Chennai are :");
		for(int i=0;i<Popularbrands.size();i++) {
			System.out.println(Popularbrands.get(i).getText());
			PopularBrands.add(Popularbrands.get(i).getText());
		}
		ExcelUtiles.SaveCarsData(PopularBrands);
		//ExcelUtiles.closeExcel();
		Sp=new SecondPageBikes(CucmberBase.getDriver());
		Sp.Back();
		
	}
	@Given("User click on login\\/register button")
	public void user_click_on_login_register_button() throws IOException {
		
	  Fp=new FirstPageBikes(CucmberBase.getDriver());
	  Fp.LgBtn();
	  logger.info("Clicking login button");
	}

	@When("User select Google for login")
	public void user_select_google_for_login() throws InterruptedException, IOException {
		
		System.out.println("opening New Window :");
		Lp=new LoginPage(CucmberBase.getDriver());
		logger.info("Click on the google");
		Lp.ClickGoogle();
		Lp.Lgnwindow();
		logger.info("Opening new Window");
		Thread.sleep(5000);
	}

	@When("Enter the wrong email and click next")
	public void enter_the_wrong_email_and_click_next() throws InterruptedException, IOException {
		Thread.sleep(5000);
	    Lp.EnterEmail();
	    logger.info("Entering Email");
	    logger.info("Clicking Next");
	    Lp.ClickNext();
	}

	@Then("User capture the error message")
	public void user_capture_the_error_message() throws IOException {
	    Lp.ErrorMsg();
	    logger.info("Error Msg Captured");
	    
	}
	
}
