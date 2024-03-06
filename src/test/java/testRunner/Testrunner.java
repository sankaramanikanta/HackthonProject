package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFile/A_UpcomingBikes.feature",".//FeatureFile/B_UsedCars.feature",".//FeatureFile/C_Login.feature"},
		
		//features= {".//FeatureFile/A_UpcomingBikes.feature"},
		//features= {".//FeatureFile/B_UsedCars.feature"},
		//features= {".//FeatureFile/C_Login.feature"},
		//features= {".//FeatureFile/Smoke.feature"},
		
		glue= "stepDefination",
		
		plugin= {"pretty","html:reports//myreport.html",
				"json:reports/myreport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"		
		        },
		
		
		dryRun=false,
		monochrome=true,
		publish=true
		//tags="@Smoke"	
		
		)
public class Testrunner {
}
