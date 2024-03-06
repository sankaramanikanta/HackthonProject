package bikesMain;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.BaseClass;

public class Basetestng {
	public static WebDriver driver;
	 static Properties p;
	   public  static Logger logger;
	@BeforeClass (groups={"smoke"})
	   public void setup() throws IOException
	   {
	   	driver=BaseClass.initilizeBrowser(toString());	    	
	   	p=BaseClass.getProperties();
	   	driver.get(p.getProperty("appURL"));
	   	driver.manage().window().maximize(); 
	   	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   	logger=LogManager.getLogger(this.getClass());
		}

	
	

	@AfterClass(groups={"smoke"})
	public static void Close() {
		driver.quit();
	}
	
	
	
}
